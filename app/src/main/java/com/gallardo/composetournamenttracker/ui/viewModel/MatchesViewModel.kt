package com.gallardo.composetournamenttracker.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.gallardo.composetournamenttracker.domain.model.Match
import com.gallardo.composetournamenttracker.domain.usecase.MatchesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    private val useCases : MatchesUseCases
) : ViewModel() {

    private var getMatchesJob: Job? = null

    init {
        refreshMatches()
        getMatches()
    }

    private val _state = mutableStateOf(MatchesUiState.Success(emptyList()))
    val state: State<MatchesUiState.Success> = _state

    fun refreshMatches() {
        viewModelScope.launch {
            useCases.refreshMatches()
        }
    }

    sealed class MatchesUiState {
        data class Success(val matches: List<Match>): MatchesUiState()
        data class Loading(val message: String): MatchesUiState()
        data class Error(val exception: Throwable): MatchesUiState()
    }

    private fun getMatches() {
        getMatchesJob?.cancel()
        getMatchesJob = useCases.getMatches()
            .onEach { matches ->
                val temp = mutableListOf<Match>()
                matches.forEach(){
                    temp.add(it.clone())
                }
                _state.value = MatchesUiState.Success(temp)
            }
            .launchIn(viewModelScope)
    }
}