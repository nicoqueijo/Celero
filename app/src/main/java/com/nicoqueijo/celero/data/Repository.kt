package com.nicoqueijo.celero.data

import android.util.Log
import javax.inject.Inject

class Repository @Inject constructor(
    private val networkService: NetworkService,
    private val customerDao: CustomerDao
) {

    /**
     * Test
     */
    suspend fun makeApiCall() {
        val retrofitResponse = networkService.getCustomers()
        if (retrofitResponse.isSuccessful) {
            val element = retrofitResponse.body()?.let { it[0] }!!
            Log.d(
                "Nicoo",
                """
                    
                ${element.name}
                ${element.phoneNumber}
                ${element.location.address.addressLine1}
                ${element.location.address.addressLine2}
                ${element.serviceReason}
                """.trimIndent()
            )

            customerDao.upsertCustomer(element)
        }
    }
}