package com.gallardo.composetournamenttracker.data.network.model

import com.gallardo.composetournamenttracker.data.database.model.TeamEntity
import com.squareup.moshi.Json

data class NetworkTeam(
    val key: String,

    val flag: String,

    @Json(name = "group_key")
    val groupKey: String,

    val name: String
)

fun NetworkTeam.asEntity() = TeamEntity(key, flag, groupKey, name)
