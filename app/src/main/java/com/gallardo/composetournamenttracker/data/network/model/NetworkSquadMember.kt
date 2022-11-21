package com.gallardo.composetournamenttracker.data.network.model

import com.gallardo.composetournamenttracker.data.database.model.SquadMemberEntity
import com.squareup.moshi.Json

data class NetworkSquad(
    val key: String,

    val captain: Boolean,

    val name: String,

    val position: String,

    @Json (name = "team_key")
    val teamKey: String
)

fun NetworkSquad.asEntity() = SquadMemberEntity(key, captain, name, position, teamKey)
