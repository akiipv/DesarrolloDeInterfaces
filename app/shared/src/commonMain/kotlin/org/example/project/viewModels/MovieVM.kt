package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.MovieData
import org.example.project.states.MovieState
import kotlin.time.Duration.Companion.hours

class MovieVM : ViewModel() {
    private val _uiState = MutableStateFlow(MovieState())
    val uiState: StateFlow<MovieState> = _uiState

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val items = listOf(
            MovieData("Campanilla", "Fantasía", 1.3.hours),
            MovieData("La Bella y la Bestia", "Animación", 1.25.hours),
            MovieData("El Padrino", "Drama", 2.5.hours)
        )

        _uiState.update { currentState ->
            currentState.copy(items = items)
        }
    }
}