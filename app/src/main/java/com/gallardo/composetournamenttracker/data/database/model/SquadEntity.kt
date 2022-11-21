package com.gallardo.composetournamenttracker.data.database.model

import androidx.room.*
import com.gallardo.composetournamenttracker.domain.model.SquadMember

@Entity
data class SquadMemberEntity(
    @PrimaryKey
    val key: String,
    val captain: Boolean,
    val name: String,
    val position: String,
    @ColumnInfo(name = "team_key")
    val teamKey: String
)

fun SquadMemberEntity.asDomain() = SquadMember(key, captain, name, position, teamKey)
