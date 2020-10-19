package com.nicoqueijo.celero.data

import com.nicoqueijo.celero.model.Customer
import javax.inject.Inject

class Repository @Inject constructor(
    private val networkService: NetworkService,
    private val customerDao: CustomerDao
) {
    suspend fun getLocalCustomers() = customerDao.getCustomers()

    suspend fun isCustomerTableEmpty() = customerDao.getCustomerCount() == 0

    suspend fun getRemoteCustomers() = networkService.getCustomers()

    suspend fun deleteCustomers() = customerDao.deleteCustomers()

    suspend fun upsertCustomers(customers: List<Customer>) = customerDao.upsertCustomers(customers)
}