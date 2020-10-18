package com.nicoqueijo.celero.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nicoqueijo.celero.model.Customer

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCustomer(customer: Customer)

    @Transaction
    suspend fun upsertCustomers(currencies: List<Customer>) {
        currencies.forEach { upsertCustomer(it) }
    }

    @Query("SELECT * FROM Customer ORDER BY visitOrder ASC")
    fun getCustomers(): LiveData<MutableList<Customer>>

}