package com.gallardo.composetournamenttracker.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gallardo.composetournamenttracker.ui.BracketsScreen
import com.gallardo.composetournamenttracker.ui.GroupsScreen
import com.gallardo.composetournamenttracker.ui.LiveScreen
import com.gallardo.composetournamenttracker.ui.MatchesScreen
import com.gallardo.composetournamenttracker.ui.viewModel.GroupsViewModel
import com.gallardo.composetournamenttracker.ui.viewModel.MatchesViewModel

@Composable
fun TournamentTrackerNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Groups.screen_route) {
        composable(BottomNavItem.Groups.screen_route) {
            val viewModel = hiltViewModel<GroupsViewModel>()
            GroupsScreen(viewModel)
        }
        composable(BottomNavItem.Matches.screen_route) {
            val viewModel = hiltViewModel<MatchesViewModel>()
            MatchesScreen(viewModel)
        }
        composable(BottomNavItem.Brackets.screen_route) {
            BracketsScreen()
        }
        composable(BottomNavItem.Live.screen_route) {
            LiveScreen()
        }
    }
}