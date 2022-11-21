package com.gallardo.composetournamenttracker.domain.usecase

import com.gallardo.composetournamenttracker.domain.model.Group
import com.gallardo.composetournamenttracker.domain.repository.GroupsRepository
import kotlinx.coroutines.flow.*

class GetGroupsUseCase (private val repository : GroupsRepository) {

    operator fun invoke() : Flow<List<Group>> {

        val groups = repository.getGroupsStream()
        val matches = repository.getMatchesStream()
        val teams = repository.getTeamsStream()
        val goals = repository.getGoalsStream()

        val combined = combine(groups, teams, matches, goals) { cGroup, cTeam, cMatch, cGoal ->

            cGroup.forEach() { group ->
                group.teams.clear()
                group.teams.addAll(cTeam.filter { team ->
                    team.groupKey == group.key
                })
            }

            cTeam.forEach() { team ->
                team.matches.clear()
                team.matches.addAll(cMatch.filter { match ->
                    match.teamOneKey == team.key || match.teamTwoKey == team.key
                })
            }

            cMatch.forEach { match ->
                match.goals.clear()
                match.goals.addAll(cGoal.filter { goal ->
                    goal.matchKey == match.key
                })
            }
            cGroup
        }
        return combined
    }


}