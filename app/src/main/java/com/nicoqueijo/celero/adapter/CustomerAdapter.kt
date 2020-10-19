package com.nicoqueijo.celero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nicoqueijo.celero.databinding.RowCustomerBinding
import com.nicoqueijo.celero.model.Customer
import com.nicoqueijo.celero.view.CustomerDialogFragment
import com.nicoqueijo.celero.view.MainActivity

class CustomerAdapter(private val customers: List<Customer>) :
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    inner class CustomerViewHolder(private val binding: RowCustomerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val profilePicture = binding.profilePicture

        init {
            itemView.setOnClickListener {
                CustomerDialogFragment(customers[adapterPosition]).show(
                    (itemView.context as MainActivity).supportFragmentManager, "dialog"
                )
            }
        }

        fun bind(customer: Customer) {
            binding.customer = customer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val binding = RowCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.apply {
            bind(customers[position])
            Glide.with(itemView)
                .load(customers[position].profilePicture.medium)
                .into(profilePicture)
        }
    }

    override fun getItemCount() = customers.size
}