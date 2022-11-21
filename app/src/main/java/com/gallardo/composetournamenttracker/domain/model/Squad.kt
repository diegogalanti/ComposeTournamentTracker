package com.gallardo.composetournamenttracker.domain.model

data class SquadMember(
    val key: String,
    val captain: Boolean,
    val name: String,
    val position: String,
    val teamKey: String
)