package com.nicoqueijo.celero.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.nicoqueijo.celero.R
import com.nicoqueijo.celero.databinding.DialogCustomerBinding
import com.nicoqueijo.celero.model.Customer

class CustomerDialogFragment(private val customer: Customer) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<DialogCustomerBinding>(
            inflater, R.layout.dialog_customer, container, false
        )
        binding.customer = customer
        return binding.root
    }
}