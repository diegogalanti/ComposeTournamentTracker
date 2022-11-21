package com.gallardo.composetournamenttracker.domain.model

data class Goal(
    val key: String,
    val matchKey: String,
    val moment: String,
    val ownGoal: Boolean,
    val squadKey: String,
    val teamKey: String
)