package com.gallardo.composetournamenttracker.domain.usecase

import com.gallardo.composetournamenttracker.domain.model.Match
import com.gallardo.composetournamenttracker.domain.repository.MatchesRepository
import kotlinx.coroutines.flow.*

class GetMatchesUseCase (private val repository : MatchesRepository) {

    operator fun invoke() : Flow<List<Match>> {
        val matches = repository.getMatches()
        val teams = repository.getTeams()
        val goals = repository.getGoals()

        val combined = combine(matches, teams, goals) { cMatches, cTeams, cGoals ->
            cMatches.forEach { match ->
                match.teams.clear()
                match.teams.addAll(cTeams.filter { team ->
                    team.key == match.teamOneKey || team.key == match.teamTwoKey
                })
                match.goals.clear()
                match.goals.addAll(cGoals.filter { goal ->
                    goal.matchKey == match.key
                })
            }
            cMatches
        }
        return combined
    }
}