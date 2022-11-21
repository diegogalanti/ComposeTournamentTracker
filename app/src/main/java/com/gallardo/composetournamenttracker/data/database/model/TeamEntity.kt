package com.gallardo.composetournamenttracker.data.database.model

import androidx.room.*
import com.gallardo.composetournamenttracker.domain.model.Team

@Entity
data class TeamEntity(
    @PrimaryKey
    val key: String,
    val flag: String,
    @ColumnInfo(name = "group_key")
    val groupKey: String,
    val name: String
)

fun TeamEntity.asDomain() = Team(key, flag, groupKey, name, mutableListOf())
