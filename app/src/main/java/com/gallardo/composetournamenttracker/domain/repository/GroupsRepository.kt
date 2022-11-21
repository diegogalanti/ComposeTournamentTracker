package com.gallardo.composetournamenttracker.domain.repository

import com.gallardo.composetournamenttracker.domain.model.Goal
import com.gallardo.composetournamenttracker.domain.model.Group
import com.gallardo.composetournamenttracker.domain.model.Match
import com.gallardo.composetournamenttracker.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface GroupsRepository {
    fun getGroupsStream(): Flow<List<Group>>

    fun getMatchesStream(): Flow<List<Match>>

    fun getTeamsStream(): Flow<List<Team>>

    fun getGoalsStream(): Flow<List<Goal>>

    suspend fun refreshGroupsDatabase()
}