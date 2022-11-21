package com.gallardo.composetournamenttracker.data.database.di

import android.content.Context
import androidx.room.Room
import com.gallardo.composetournamenttracker.data.database.TournamentTrackerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): TournamentTrackerDatabase {
        return Room.databaseBuilder(
            context,
            TournamentTrackerDatabase::class.java,
            TournamentTrackerDatabase.DATABASE_NAME
        )
            .build()
    }
}