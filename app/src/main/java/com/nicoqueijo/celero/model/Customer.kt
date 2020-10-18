package com.nicoqueijo.celero.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nicoqueijo.celero.util.Utils.getAbbreviatedState
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
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

@JsonClass(generateAdapter = true)
data class ProfilePicture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

@JsonClass(generateAdapter = true)
data class Location(
    @Embedded
    val address: Address,
    @Embedded
    val coordinate: Coordinate
)

@JsonClass(generateAdapter = true)
data class Address(
    val street: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String
) {
    val addressLine1
        get() = street
    val addressLine2
        get() = "$city, ${getAbbreviatedState(state)} $postalCode"
}

@JsonClass(generateAdapter = true)
data class Coordinate(
    val latitude: String,
    val longitude: String
)
