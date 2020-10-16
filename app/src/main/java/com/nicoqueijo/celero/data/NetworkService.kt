package com.nicoqueijo.celero.data

import com.nicoqueijo.celero.model.Customer
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {

    @GET(END_POINT)
    suspend fun getCustomers(): Response<List<Customer>>

    companion object {
        const val BASE_URL = "https://hulet.tech/"
        const val END_POINT = "celerocustomers.json"
    }
}