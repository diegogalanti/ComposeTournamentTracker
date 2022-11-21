package com.gallardo.composetournamenttracker.domain.model

data class Team(
    val key: String,
    val flag: String,
    val groupKey: String,
    val name: String,
    val matches: MutableList<Match>
) : Cloneable {
    public override fun clone(): Team {
        val team = Team(key, flag, groupKey, name, mutableListOf())
        matches.forEach() {
            team.matches.add(it.clone())
        }
        return team
    }
}