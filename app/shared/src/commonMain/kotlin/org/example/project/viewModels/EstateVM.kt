package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.EstateData
import org.example.project.states.EstateState

class EstateVM : ViewModel() {
    private val _uiState = MutableStateFlow(EstateState())
    val uiState: StateFlow<EstateState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val items = listOf(
            EstateData(1, "Finca finquette", "Lechuga de agua", 44, true),
            EstateData(2, "Lejana Pradera", "Mango menta", 37, false),
            EstateData(3, "Las Pozas de Marea", "Remolacha corazón", 46, false)
        )

        _uiState.update { currentState ->
            currentState.copy(items = items)
        }
    }

    fun modifyWaterNeed(id: Int) {
        _uiState.update { currentState -> currentState.copy(
            items = currentState.items.map { item ->
                if (item.id == id) item.copy(needsWater = !item.needsWater)
                else item
            }
        )}
    }
}