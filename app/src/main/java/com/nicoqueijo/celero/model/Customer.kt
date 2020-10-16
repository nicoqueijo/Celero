package com.nicoqueijo.celero.model

import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Customer(
    @PrimaryKey
    val identifier: Int,
    val visitOrder: Int,
    val name: String,
    val phoneNumber: String,
    val profilePicture: ProfilePicture,
    val location: Location,
    val serviceReason: String,
    val problemPictures: List<String>
)

