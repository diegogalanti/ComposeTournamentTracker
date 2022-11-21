package com.gallardo.composetournamenttracker.data.network

import com.gallardo.composetournamenttracker.data.database.toString
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.*

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class StringToBoolean

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class StringToDate

class JsonAdapters {
    @ToJson
    fun booleanToJson(@StringToBoolean option: Boolean): String {
        return if (option) "TRUE" else "FALSE"
    }

    @FromJson
    @StringToBoolean
    fun booleanFromJson(option: String): Boolean {
        return option == "TRUE"
    }

    @ToJson
    fun dateToJson(@StringToDate date: Date): String {
        return date.toString("yyyyMMddHHmm")
    }

    @FromJson
    @StringToDate
    fun dateFromJson(date: String): Date {
        return when (date.length) {
            8 -> SimpleDateFormat("yyyyMMdd", Locale.US).parse(date)?:Date()
            5 -> SimpleDateFormat("HH:mm", Locale.US).parse(date)?:Date()
            else -> Date()
        }
    }
}