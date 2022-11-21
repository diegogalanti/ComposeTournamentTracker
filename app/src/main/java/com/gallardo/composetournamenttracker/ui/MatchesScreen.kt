package com.gallardo.composetournamenttracker.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.gallardo.composetournamenttracker.ui.viewModel.MatchesViewModel

@Composable
fun MatchesScreen(viewModel: MatchesViewModel) {
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
}