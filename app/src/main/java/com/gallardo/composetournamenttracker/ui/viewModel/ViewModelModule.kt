package com.gallardo.composetournamenttracker.ui.viewModel

import com.gallardo.composetournamenttracker.domain.repository.GroupsRepository
import com.gallardo.composetournamenttracker.domain.repository.GroupsRepositoryImpl
import com.gallardo.composetournamenttracker.domain.repository.MatchesRepository
import com.gallardo.composetournamenttracker.domain.repository.MatchesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ViewModelModule {
    @Binds
    fun bindsMatchesRepository(
        matchesRepository: MatchesRepositoryImpl
    ): MatchesRepository

    @Binds
    fun bindsGroupsRepository(
        groupsRepository: GroupsRepositoryImpl
    ): GroupsRepository
}