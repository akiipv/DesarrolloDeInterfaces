package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.ArtData
import org.example.project.states.ArtState

class ArtVM : ViewModel() {
    private val _uiState = MutableStateFlow(ArtState())
    val uiState: StateFlow<ArtState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val items = listOf(
            ArtData(1, "Obra 1", "Melendi", 2002, "Una obra sencilla"),
            ArtData(2, "Obra 2", "Maluma", 1890, "Loquilla"),
            ArtData(3, "Obra 3", "Yo", 2026, "Nose")
        )

        _uiState.update { currentState ->
            currentState.copy(items = items)
        }
    }

    fun selectItem(item: ArtData) {
        _uiState.update { currentState ->
            currentState.copy(selectedItem = item)
        }
    }

    fun clearSelection() {
        _uiState.update { currentState ->
            currentState.copy(selectedItem = null)
        }
    }
}