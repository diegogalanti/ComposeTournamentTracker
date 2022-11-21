package com.gallardo.composetournamenttracker.domain.usecase

import com.gallardo.composetournamenttracker.domain.repository.MatchesRepository

class RefreshMatchesUseCase (private val repository: MatchesRepository) {

    suspend operator fun invoke() {
        repository.refreshMatchesDatabase()
    }
}