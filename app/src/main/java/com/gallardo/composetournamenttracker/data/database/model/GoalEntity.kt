package com.gallardo.composetournamenttracker.data.database.model

import androidx.room.*
import com.gallardo.composetournamenttracker.domain.model.Goal

@Entity
data class GoalEntity(
    @PrimaryKey
    val key: String,

    @ColumnInfo(name = "match_id")
    val matchKey: String,

    val moment: String,

    @ColumnInfo(name = "own_goal")
    val ownGoal: Boolean,

    @ColumnInfo(name = "squad_key")
    val squadKey: String,

    @ColumnInfo(name = "team_id")
    val teamKey: String
)

fun GoalEntity.asDomain() = Goal(key, matchKey, moment, ownGoal, squadKey, teamKey)
