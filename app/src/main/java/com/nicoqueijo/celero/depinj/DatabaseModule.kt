package com.nicoqueijo.celero.depinj

import android.content.Context
import com.nicoqueijo.celero.data.CustomerDao
import com.nicoqueijo.celero.data.CustomerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideCustomerDatabase(@ApplicationContext context: Context): CustomerDatabase {
        return CustomerDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideCurrencyDao(database: CustomerDatabase): CustomerDao {
        return database.customerDao()
    }
}