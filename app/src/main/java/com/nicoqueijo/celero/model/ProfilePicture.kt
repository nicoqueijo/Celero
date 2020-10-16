package com.nicoqueijo.celero.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ProfilePicture(
    val large: String,
    val medium: String,
    val thumbnail: String
)