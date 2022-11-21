package com.gallardo.composetournamenttracker.domain.model

data class Card(
    val key: String,
    val matchKey: String,
    val squadKey: String,
    val type: String
)