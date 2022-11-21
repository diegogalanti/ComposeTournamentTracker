package com.gallardo.composetournamenttracker.domain.repository

import com.gallardo.composetournamenttracker.domain.model.Goal
import com.gallardo.composetournamenttracker.domain.model.Match
import com.gallardo.composetournamenttracker.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface MatchesRepository {
    fun getMatches(): Flow<List<Match>>

    fun getTeams(): Flow<List<Team>>

    fun getGoals(): Flow<List<Goal>>

    suspend fun refreshMatchesDatabase()
}