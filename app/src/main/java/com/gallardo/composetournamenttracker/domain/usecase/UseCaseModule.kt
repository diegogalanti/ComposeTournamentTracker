package com.gallardo.composetournamenttracker.domain.usecase

import com.gallardo.composetournamenttracker.domain.repository.GroupsRepository
import com.gallardo.composetournamenttracker.domain.repository.MatchesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGroupsUseCases(repository: GroupsRepository): GroupsUseCases {
        return GroupsUseCases(
            getGroups = GetGroupsUseCase(repository),
            refreshGroups = RefreshGroupsUseCase(repository),
        )
    }

    @Provides
    @Singleton
    fun provideMatchesUseCases(repository: MatchesRepository): MatchesUseCases {
        return MatchesUseCases(
            getMatches = GetMatchesUseCase(repository),
            refreshMatches = RefreshMatchesUseCase(repository),
        )
    }

}