package com.nicoqueijo.celero.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.nicoqueijo.celero.R
import com.nicoqueijo.celero.adapter.CustomerAdapter
import com.nicoqueijo.celero.model.Customer
import com.nicoqueijo.celero.model.Resource
import com.nicoqueijo.celero.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
@ActivityScoped
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: CustomerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeCustomers()
    }

    private fun observeCustomers() {
        viewModel.customers.observe(this, { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        initRecyclerView(it)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    showError()
                }
            }
        })
    }

    private fun initRecyclerView(customers: List<Customer>) {
        adapter = CustomerAdapter(customers)
        customer_list.apply {
            adapter = this@MainActivity.adapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            setHasFixedSize(true)
        }
    }

    private fun showError() {
        error_icon.visibility = View.VISIBLE
        error_message.visibility = View.VISIBLE
    }

    private fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }
}