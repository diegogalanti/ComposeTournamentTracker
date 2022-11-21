package com.gallardo.composetournamenttracker.domain.usecase

data class GroupsUseCases (
    val getGroups: GetGroupsUseCase,
    val refreshGroups: RefreshGroupsUseCase
)