package com.gallardo.composetournamenttracker.data.database.di

import com.gallardo.composetournamenttracker.data.database.GroupsDao
import com.gallardo.composetournamenttracker.data.database.MatchesDao
import com.gallardo.composetournamenttracker.data.database.TournamentTrackerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    fun providesMatchesDao(database : TournamentTrackerDatabase) : MatchesDao = database.matchesDao

    @Provides
    fun providesGroupsDao(database : TournamentTrackerDatabase) : GroupsDao = database.groupsDao
}