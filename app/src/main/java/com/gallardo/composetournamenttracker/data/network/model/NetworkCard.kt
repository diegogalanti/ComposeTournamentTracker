package com.gallardo.composetournamenttracker.data.network.model

import com.gallardo.composetournamenttracker.data.database.model.CardEntity
import com.squareup.moshi.Json

data class NetworkCard(
    val key: String,
    @Json(name = "match_id")
    val matchKey: String,

    @Json(name = "squad_key")
    val squadKey: String,

    val type: String
)

fun NetworkCard.asEntity() = CardEntity(key, matchKey, squadKey, type)
