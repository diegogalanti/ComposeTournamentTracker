package com.gallardo.composetournamenttracker.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gallardo.composetournamenttracker.domain.model.Card

@Entity
data class CardEntity(
    @PrimaryKey
    val key: String,
    @ColumnInfo(name = "match_id")
    val matchKey: String,

    @ColumnInfo(name = "squad_key")
    val squadKey: String,

    val type: String
)

fun CardEntity.asDomain() = Card(key, matchKey, squadKey, type)
