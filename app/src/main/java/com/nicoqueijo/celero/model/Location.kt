package com.nicoqueijo.celero.model

import androidx.room.Embedded
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    @Embedded
    val address: Address,
    val coordinate: Coordinate
)