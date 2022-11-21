package com.gallardo.composetournamenttracker.data.network.model

import com.gallardo.composetournamenttracker.data.database.model.StadiumEntity

data class NetworkStadium(
    val key: String,
    val name: String
)

fun NetworkStadium.asEntity() = StadiumEntity(key, name)
