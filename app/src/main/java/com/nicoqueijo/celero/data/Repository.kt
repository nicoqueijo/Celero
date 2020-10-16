package com.nicoqueijo.celero.data

import android.util.Log
import com.nicoqueijo.celero.model.Customer
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val networkService: NetworkService
) {

    /**
     * Test
     */
    suspend fun makeApiCall() {
        val retrofitResponse: Response<List<Customer>>
        retrofitResponse = networkService.getCustomers()
        if (retrofitResponse.isSuccessful) {
            Log.d("Nicoo", retrofitResponse.body().toString())
        }
    }

}