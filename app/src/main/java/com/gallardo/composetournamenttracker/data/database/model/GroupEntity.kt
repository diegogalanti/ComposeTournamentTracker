package com.gallardo.composetournamenttracker.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gallardo.composetournamenttracker.domain.model.Group

@Entity
data class GroupEntity(
    @PrimaryKey
    @ColumnInfo(name = "key")
    val key: String,
    @ColumnInfo(name = "group_name")
    val name: String
)

fun GroupEntity.asDomain() = Group(key, name, mutableListOf())