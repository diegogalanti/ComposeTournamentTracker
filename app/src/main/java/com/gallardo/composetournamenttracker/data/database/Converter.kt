package com.gallardo.composetournamenttracker.data.database

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {
    @TypeConverter
    fun stringToDate(string: String): Date? {
        return when (string.length) {
            12 -> SimpleDateFormat("yyyyMMddHHmm", Locale.US).parse(string)
            else -> Date()
        }
    }

    @TypeConverter
    fun dateToString(date: Date): String {
        return date.toString("yyyyMMddHHmm")
    }
}

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}
