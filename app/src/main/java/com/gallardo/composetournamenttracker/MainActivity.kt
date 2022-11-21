package com.gallardo.composetournamenttracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.gallardo.composetournamenttracker.ui.components.navigation.BottomNavItem
import com.gallardo.composetournamenttracker.ui.components.navigation.BottomNavigationBar
import com.gallardo.composetournamenttracker.ui.components.navigation.TournamentTrackerNavHost
import com.gallardo.composetournamenttracker.ui.theme.ComposeTournamentTrackerTheme
import com.gallardo.composetournamenttracker.ui.viewModel.GroupsViewModel
import com.gallardo.composetournamenttracker.ui.viewModel.MatchesViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val matchesViewModel: MatchesViewModel by viewModels()
    private val groupsViewModel: GroupsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            matchesViewModel.refreshMatches()
            groupsViewModel.refreshGroups()
        }


//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                groupsViewModel.state.collect { uiState ->
//                    when (uiState) {
//                        is GroupsViewModel.GroupsUiState.Success -> Log.e("ABC2", uiState.groups.toString())
////                        is GroupsViewModel.GroupsUiState.Error -> showError(uiState.exception)
//                    }
//                }
//            }
//        }

        setContent {
            ComposeTournamentTrackerTheme {
                MainScreenView()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView() {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )

        // setStatusBarColor() and setNavigationBarColor() also exist

        onDispose {}
    }

    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavItem.Groups,
        BottomNavItem.Matches,
        BottomNavItem.Brackets,
        BottomNavItem.Live
    )
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = bottomNavigationItems
            )
        }
    ) { paddingValues ->
        TournamentTrackerNavHost(navController)
    }
}