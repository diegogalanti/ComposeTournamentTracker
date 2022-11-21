package com.gallardo.composetournamenttracker.domain.usecase

data class MatchesUseCases (
    val getMatches: GetMatchesUseCase,
    val refreshMatches: RefreshMatchesUseCase
)