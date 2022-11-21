package com.gallardo.composetournamenttracker.data.database

import androidx.room.*
import com.gallardo.composetournamenttracker.data.database.model.*

@Database(
    entities = [CardEntity::class, GoalEntity::class, GroupEntity::class, MatchEntity::class, SquadMemberEntity::class, StadiumEntity::class, TeamEntity::class],
    version = 1
)
abstract class TournamentTrackerDatabase : RoomDatabase() {

    abstract val matchesDao: MatchesDao

    abstract val groupsDao: GroupsDao

    companion object {
        const val DATABASE_NAME = "tt_database"
    }
}