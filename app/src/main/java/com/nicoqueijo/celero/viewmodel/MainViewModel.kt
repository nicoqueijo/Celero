package com.nicoqueijo.celero.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.nicoqueijo.celero.data.Repository
import dagger.hilt.android.scopes.ActivityRetainedScoped

@ActivityRetainedScoped
class MainViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {

    suspend fun makeApiCall() {
        repository.makeApiCall()
    }

}