package com.gallardo.composetournamenttracker.domain.model

data class Group(
    val key: String,
    val name: String,
    val teams: MutableList<Team>
) : Cloneable {
    public override fun clone(): Group {
        val group = Group(key, name, mutableListOf())
        teams.forEach() {
            group.teams.add(it.clone())
        }
        return group
    }
}