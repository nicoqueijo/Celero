package com.nicoqueijo.celero.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
@Entity
data class Customer(
    @PrimaryKey
    val identifier: Int,
    val visitOrder: Int,
    val name: String,
    val phoneNumber: String,
    @Embedded
    val profilePicture: ProfilePicture,
    @Embedded
    val location: Location,
    val serviceReason: String,
    val problemPictures: List<String>
)

