package com.nicoqueijo.celero.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicoqueijo.celero.data.Repository
import com.nicoqueijo.celero.model.Customer
import com.nicoqueijo.celero.model.Resource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.launch
import retrofit2.Response

@ActivityRetainedScoped
class MainViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {

    val customers: MutableLiveData<Resource<List<Customer>>> = MutableLiveData()

    init {
        getCustomers()
    }

    private fun getCustomers() = viewModelScope.launch {
        customers.postValue(Resource.Loading())
        val response: Response<List<Customer>>
        try {
            response = repository.getRemoteCustomers()
        } catch (e: Exception) {
            customers.postValue(Resource.Error(e.message))
            return@launch
        }
        when (val resource = handleResponse(response)) {
            is Resource.Success -> {
                repository.deleteCustomers()
                resource.data?.let {
                    repository.upsertCustomers(it)
                }
                customers.postValue(Resource.Success(repository.getLocalCustomers()))
            }
            is Resource.Error -> {
                if (repository.isCustomerTableEmpty()) {
                    customers.postValue(Resource.Error(resource.message))
                } else {
                    customers.postValue(Resource.Success(repository.getLocalCustomers()))
                }
            }
        }
    }

    private fun handleResponse(response: Response<List<Customer>>): Resource<List<Customer>> {
        if (response.isSuccessful) {
            response.body()?.let { return Resource.Success(it) }
        }
        return Resource.Error(response.message())
    }
}