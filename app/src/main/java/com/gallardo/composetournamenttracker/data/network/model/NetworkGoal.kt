package com.gallardo.composetournamenttracker.data.network.model

import com.gallardo.composetournamenttracker.data.database.model.GoalEntity
import com.gallardo.composetournamenttracker.data.network.StringToBoolean
import com.squareup.moshi.Json

data class NetworkGoal(
    @Json(name = "key")
    val Key: String,

    @Json(name = "match_id")
    val matchKey: String,

    val moment: String,

    @StringToBoolean
    @Json(name = "own_goal")
    val ownGoal: Boolean,

    @Json(name = "squad_key")
    val squadKey: String,

    @Json(name = "team_id")
    val teamKey: String
)

fun NetworkGoal.asEntity() = GoalEntity(Key, matchKey, moment, ownGoal, squadKey, teamKey)
