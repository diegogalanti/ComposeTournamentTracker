package com.gallardo.composetournamenttracker.domain.repository

import android.util.Log
import com.gallardo.composetournamenttracker.data.database.GroupsDao
import com.gallardo.composetournamenttracker.data.database.model.asDomain
import com.gallardo.composetournamenttracker.data.network.TournamentTrackerNetworkDataSource
import com.gallardo.composetournamenttracker.data.network.model.asEntity
import com.gallardo.composetournamenttracker.domain.model.Goal
import com.gallardo.composetournamenttracker.domain.model.Group
import com.gallardo.composetournamenttracker.domain.model.Match
import com.gallardo.composetournamenttracker.domain.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GroupsRepositoryImpl @Inject constructor(
    private val groupsDao: GroupsDao,
    private val networkDataSource: TournamentTrackerNetworkDataSource
) :
    GroupsRepository {

    override fun getGroupsStream(): Flow<List<Group>> {
        return groupsDao.getGroups().map { groupsEntity ->
            groupsEntity.map { currentGroupEntity ->
                currentGroupEntity.asDomain()
            }
        }
    }

    override fun getMatchesStream(): Flow<List<Match>> {
        return groupsDao.getMatches().map { matchesEntity ->
            matchesEntity.map { currentMatchEntity ->
                currentMatchEntity.asDomain()
            }
        }

    }

    override fun getTeamsStream(): Flow<List<Team>> {
        return groupsDao.getTeams().map { teamsEntity ->
            teamsEntity.map { currentTeamEntity ->
                currentTeamEntity.asDomain()
            }
        }

    }

    override fun getGoalsStream(): Flow<List<Goal>> {
        return groupsDao.getGoals().map { goalsEntity ->
            goalsEntity.map { currentGoalEntity ->
                currentGoalEntity.asDomain()
            }
        }
    }

    override suspend fun refreshGroupsDatabase() {
        withContext(Dispatchers.IO) {
            try {
                refreshGroups()
            } catch (e: Exception) {
                Log.e("Error", e.toString())
            }
        }
    }

    private suspend fun refreshGroups() {
        val groups = networkDataSource.getGroups().items
        val teams = networkDataSource.getTeams().items
        val matches = networkDataSource.getMatches().items
        val goals = networkDataSource.getGoals().items

        groupsDao.insertGroups(groups.map { it.asEntity() })
        groupsDao.insertTeams(teams.map { it.asEntity() })
        groupsDao.insertMatches(matches.map { it.asEntity() })
        groupsDao.insertGoals(goals.map { it.asEntity() })
    }

//    private fun fillResult(
//        teamWithResults: TeamWithGroupResultEntity,
//        matches: List<MatchEntity>, goals: List<NetworkGoal>
//    ) {
//        var totalGoalFor = 0
//        var totalGoalAgainst = 0
//        var goalFor = 0
//        var goalAgainst = 0
//        var won = 0
//        var lost = 0
//        var drawn = 0
//        matches.forEach() { currentMatch ->
//            goalFor = 0
//            goalAgainst = 0
//            goals.filter { it.matchKey == currentMatch.key }.forEach() { currentGoal ->
//                if ((currentGoal.teamKey == teamWithResults.key && !currentGoal.ownGoal) || (currentGoal.teamKey != teamWithResults.key && currentGoal.ownGoal))
//                    goalFor++
//                else
//                    goalAgainst++
//            }
//            totalGoalFor += goalFor
//            totalGoalAgainst += goalAgainst
//            when (goalFor - goalAgainst) {
//                0 -> drawn++
//                in 0..Int.MAX_VALUE -> won++
//                else -> lost++
//            }
//        }
//        teamWithResults.goalFor = totalGoalFor
//        teamWithResults.goalAgainst = totalGoalAgainst
//        teamWithResults.won = won
//        teamWithResults.lost = lost
//        teamWithResults.drawn = drawn
//    }
}