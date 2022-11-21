package com.gallardo.composetournamenttracker.domain.repository

import com.gallardo.composetournamenttracker.data.network.TournamentTrackerNetwork
import com.gallardo.composetournamenttracker.data.network.TournamentTrackerNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindNetworkDataSource(retrofitNetworkDS : TournamentTrackerNetwork) : TournamentTrackerNetworkDataSource
}