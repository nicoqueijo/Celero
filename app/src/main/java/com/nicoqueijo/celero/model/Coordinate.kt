package com.nicoqueijo.celero.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coordinate(
    val latitude: String,
    val longitude: String
)
