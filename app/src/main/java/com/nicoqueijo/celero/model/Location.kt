package com.nicoqueijo.celero.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    val address: Address,
    val coordinate: Coordinate
)