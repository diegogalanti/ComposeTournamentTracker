package com.gallardo.composetournamenttracker.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.gallardo.composetournamenttracker.domain.model.Group
import com.gallardo.composetournamenttracker.domain.usecase.GroupsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroupsViewModel @Inject constructor(
    private val useCases: GroupsUseCases
) : ViewModel() {

    private var getGroupsJob: Job? = null

    init {
        refreshGroups()
        getGroups()
    }

    private val _state = mutableStateOf(GroupsUiState.Success(emptyList(), emptyList()))
    val state: State<GroupsUiState.Success> = _state

    fun refreshGroups() {
        viewModelScope.launch {
            useCases.refreshGroups()
        }
    }

    fun onExpandClicked(groupKey: String)
    {
        val newList = _state.value.expandedGroups.toMutableList()

        if (newList.contains(groupKey))
            newList.remove(groupKey)
        else
            newList.add(groupKey)
        _state.value = state.value.copy(expandedGroups = newList)
    }

    sealed interface GroupsUiState {
        data class Success(val groups: List<Group>, val expandedGroups : List<String>) : GroupsUiState
        data class Loading(val description: String) : GroupsUiState
        data class Error(val description: String) : GroupsUiState
    }

    private fun getGroups() {
        getGroupsJob?.cancel()
        getGroupsJob = useCases.getGroups()
            .onEach { groups ->
                val temp = mutableListOf<Group>()
                groups.forEach() {
                    temp.add(it.clone())
                }
                _state.value = state.value.copy(groups = temp)
            }
            .launchIn(viewModelScope)
    }
}