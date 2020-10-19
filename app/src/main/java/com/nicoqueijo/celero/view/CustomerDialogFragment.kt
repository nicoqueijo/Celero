package com.nicoqueijo.celero.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.nicoqueijo.celero.R
import com.nicoqueijo.celero.adapter.ProblemPictureAdapter
import com.nicoqueijo.celero.databinding.DialogCustomerBinding
import com.nicoqueijo.celero.model.Customer

class CustomerDialogFragment(private val customer: Customer) : DialogFragment() {

    private lateinit var adapter: ProblemPictureAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<DialogCustomerBinding>(
            inflater, R.layout.dialog_customer, container, false
        )
        binding.customer = customer
        adapter = ProblemPictureAdapter(customer.problemPictures)
        binding.problemPictures.adapter = adapter
        binding.problemPictures.setHasFixedSize(true)
        Glide.with(binding.root)
            .load(customer.profilePicture.large)
            .into(binding.profilePicture)
        return binding.root
    }
}