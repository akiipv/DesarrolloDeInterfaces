package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.MovieData
import org.example.project.states.MovieState

class MovieVM : ViewModel() {
    private val _uiState = MutableStateFlow(MovieState())
    val uiState: StateFlow<MovieState> = _uiState

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val items = listOf(
            MovieData("Campanilla", "Finca finquette", "Lechuga de agua", 44, true),
            MovieData("", "Lejana Pradera", "Mango menta", 37, false),
            MovieData(3, "Las Pozas de Marea", "Remolacha corazón", 46, false)
        )

        _uiState.update { currentState ->
            currentState.copy(items = items)
        }
    }
}