package com.nicoqueijo.celero.data

import androidx.room.*
import com.nicoqueijo.celero.model.Customer

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCustomer(customer: Customer)

    @Transaction
    suspend fun upsertCustomers(customers: List<Customer>) {
        customers.forEach { upsertCustomer(it) }
    }

    @Query("DELETE FROM Customer")
    suspend fun deleteCustomers()

    @Query("SELECT * FROM Customer ORDER BY visitOrder ASC")
    suspend fun getCustomers(): List<Customer>

    @Query("SELECT COUNT(*) FROM Customer")
    suspend fun getCustomerCount(): Int
}