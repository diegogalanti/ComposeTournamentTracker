package com.gallardo.composetournamenttracker.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.gallardo.composetournamenttracker.data.database.DateConverter
import com.gallardo.composetournamenttracker.domain.model.Match
import java.util.*

@Entity
@TypeConverters(DateConverter::class)
data class MatchEntity(
    @PrimaryKey
    val key: String,

    val date: Date,

    @ColumnInfo(name = "group_key")
    val groupKey: String,

    @ColumnInfo(name = "match_number")
    val matchNumber: Int,

    @ColumnInfo(name = "stadium_key")
    val stadiumKey: String,

    @ColumnInfo(name = "team_two_key")
    val teamTwoKey: String,

    @ColumnInfo(name = "team_one_key")
    val teamOneKey: String,

    val time: Date
)

fun MatchEntity.asDomain() =
    Match(key, date, groupKey, matchNumber, stadiumKey, teamTwoKey, teamOneKey, time, mutableListOf(), mutableListOf())