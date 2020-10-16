package com.nicoqueijo.celero.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address(
    val street: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String
)
