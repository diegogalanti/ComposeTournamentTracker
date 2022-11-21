package com.gallardo.composetournamenttracker.domain.repository

import android.util.Log
import com.gallardo.composetournamenttracker.data.database.MatchesDao
import com.gallardo.composetournamenttracker.data.database.model.asDomain
import com.gallardo.composetournamenttracker.data.network.TournamentTrackerNetworkDataSource
import com.gallardo.composetournamenttracker.data.network.model.asEntity
import com.gallardo.composetournamenttracker.domain.model.Goal
import com.gallardo.composetournamenttracker.domain.model.Match
import com.gallardo.composetournamenttracker.domain.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(private val matchesDao: MatchesDao, private val networkDataSource : TournamentTrackerNetworkDataSource) :
    MatchesRepository {

    override fun getMatches(): Flow<List<Match>> {
        return matchesDao.getMatches().map {
            it.map { current ->
                current.asDomain()
            }
        }
    }

    override fun getTeams(): Flow<List<Team>> {
        return matchesDao.getTeams().map {
            it.map { current ->
                current.asDomain()
            }
        }
    }

    override fun getGoals(): Flow<List<Goal>> {
        return matchesDao.getGoals().map {
            it.map { current ->
                current.asDomain()
            }
        }
    }

    override suspend fun refreshMatchesDatabase() {
        withContext(Dispatchers.IO) {
            try {
                refreshMatches()
            } catch (e: Exception) {
                Log.e("Error", e.toString())
            }
        }
    }

    private suspend fun refreshMatches() {
        val matches = networkDataSource.getMatches().items
        val teams = networkDataSource.getTeams().items
        val goals = networkDataSource.getGoals().items
        matchesDao.insertMatches(matches.map { it.asEntity() })
        matchesDao.insertTeams(teams.map { it.asEntity() })
        matchesDao.insertGoals(goals.map { it.asEntity() })
    }
}