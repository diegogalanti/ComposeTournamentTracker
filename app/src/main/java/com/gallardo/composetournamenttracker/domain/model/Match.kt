package com.gallardo.composetournamenttracker.domain.model

import java.util.*

data class Match(
    val key: String,
    val date: Date,
    val groupKey: String,
    val matchNumber: Int,
    val stadiumKey: String,
    val teamTwoKey: String,
    val teamOneKey: String,
    val time: Date,
    val goals: MutableList<Goal>,
    val teams: MutableList<Team>
) : Cloneable {
    public override fun clone(): Match {
        val match = Match(key, date, groupKey, matchNumber, stadiumKey, teamTwoKey, teamOneKey, time, mutableListOf(), mutableListOf())
        goals.forEach() {
            match.goals.add(it.copy())
        }
        teams.forEach() {
            match.teams.add(it.copy())
        }
        return match
    }
}