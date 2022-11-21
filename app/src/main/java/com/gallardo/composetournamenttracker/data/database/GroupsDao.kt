package com.gallardo.composetournamenttracker.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gallardo.composetournamenttracker.data.database.model.GoalEntity
import com.gallardo.composetournamenttracker.data.database.model.GroupEntity
import com.gallardo.composetournamenttracker.data.database.model.MatchEntity
import com.gallardo.composetournamenttracker.data.database.model.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupsDao {

    @Query("SELECT * FROM GroupEntity")
    fun getGroups() : Flow<List<GroupEntity>>

    @Query("SELECT * FROM TeamEntity")
    fun getTeams() : Flow<List<TeamEntity>>

    @Query("SELECT * FROM MatchEntity")
    fun getMatches() : Flow<List<MatchEntity>>

    @Query("SELECT * FROM GoalEntity")
    fun getGoals() : Flow<List<GoalEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroups(groups: List<GroupEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeams(teams: List<TeamEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatches(matches: List<MatchEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoals(goals: List<GoalEntity>)
}