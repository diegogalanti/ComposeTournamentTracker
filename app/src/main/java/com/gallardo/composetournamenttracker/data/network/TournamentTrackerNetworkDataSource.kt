package com.gallardo.composetournamenttracker.data.network

import com.gallardo.composetournamenttracker.data.network.model.*

interface TournamentTrackerNetworkDataSource {
    suspend fun getGroups(): GroupResponse

    suspend fun getCards(): CardResponse

    suspend fun getGoals(): GoalResponse

    suspend fun getMatches(): MatchResponse

    suspend fun getSquads(): SquadResponse

    suspend fun getStadiums(): StadiumResponse

    suspend fun getTeams(): TeamResponse
}
