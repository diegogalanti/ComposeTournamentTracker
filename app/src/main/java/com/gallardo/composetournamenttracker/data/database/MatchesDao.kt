package com.gallardo.composetournamenttracker.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gallardo.composetournamenttracker.data.database.model.GoalEntity
import com.gallardo.composetournamenttracker.data.database.model.TeamEntity
import com.gallardo.composetournamenttracker.data.database.model.MatchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchesDao {

    @Query("SELECT * FROM MatchEntity")
    fun getMatches(): Flow<List<MatchEntity>>

    @Query("SELECT * FROM TeamEntity")
    fun getTeams(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM GoalEntity")
    fun getGoals(): Flow<List<GoalEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatches(matches: List<MatchEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeams(teams: List<TeamEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoals(teams: List<GoalEntity>)

}