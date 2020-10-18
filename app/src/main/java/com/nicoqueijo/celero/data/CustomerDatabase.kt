package com.nicoqueijo.celero.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nicoqueijo.celero.model.Customer

@Database(entities = [Customer::class], version = 1)
@TypeConverters(Converters::class)
abstract class CustomerDatabase : RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {

        private const val DATABASE_NAME = "customer.db"

        @Volatile
        private var instance: CustomerDatabase? = null

        fun getInstance(context: Context): CustomerDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): CustomerDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                CustomerDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}