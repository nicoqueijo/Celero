package com.nicoqueijo.celero.data

import androidx.room.TypeConverter

object Converters {

    @JvmStatic
    @TypeConverter
    fun toProblemPictures(problemPictures: String): List<String> {
        return problemPictures.split(",").map { it }
    }

    @JvmStatic
    @TypeConverter
    fun fromProblemPictures(problemPictures: List<String>): String {
        return problemPictures.joinToString(separator = ",")
    }
}