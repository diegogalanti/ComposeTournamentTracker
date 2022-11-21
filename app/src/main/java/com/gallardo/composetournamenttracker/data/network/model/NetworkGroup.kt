package com.gallardo.composetournamenttracker.data.network.model

import com.gallardo.composetournamenttracker.data.database.model.GroupEntity

data class NetworkGroup(
    val key: String,
    val name: String
)

fun NetworkGroup.asEntity() = GroupEntity(key, name)
