package com.gallardo.composetournamenttracker.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gallardo.composetournamenttracker.ui.components.GroupCard
import com.gallardo.composetournamenttracker.ui.viewModel.GroupsViewModel


@Composable
fun GroupsScreen(viewModel: GroupsViewModel) {
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Log.e("OXI","OXI")
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
    ) {
        items(items = state.groups) { group ->
            GroupCard(group, modifier = Modifier.fillMaxWidth(), state.expandedGroups.contains(group.key), onExpand = { viewModel.onExpandClicked(it)})
            Spacer(modifier = Modifier.height(8.dp))
        }
    }


}