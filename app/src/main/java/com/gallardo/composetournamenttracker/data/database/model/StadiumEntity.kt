package com.gallardo.composetournamenttracker.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gallardo.composetournamenttracker.domain.model.Stadium

@Entity
data class StadiumEntity(
    @PrimaryKey
    val key: String,
    val name: String
)

fun StadiumEntity.asDomain() = Stadium(key, name)
