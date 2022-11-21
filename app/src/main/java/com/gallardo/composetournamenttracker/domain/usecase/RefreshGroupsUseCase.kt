package com.gallardo.composetournamenttracker.domain.usecase

import com.gallardo.composetournamenttracker.domain.repository.GroupsRepository

class RefreshGroupsUseCase (private val repository: GroupsRepository) {

    suspend operator fun invoke() {
        repository.refreshGroupsDatabase()
    }
}