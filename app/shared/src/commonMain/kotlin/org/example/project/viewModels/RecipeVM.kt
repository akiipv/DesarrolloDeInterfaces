package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.RecipeData
import org.example.project.states.RecipeState

class RecipeVM : ViewModel() {
    private val _uiState = MutableStateFlow(RecipeState())
    val uiState: StateFlow<RecipeState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val items = listOf(
            RecipeData("Tarta de queso", "Postre", 24, false),
            RecipeData("Tortilla de patatas", "Plato principal", 35, true),
            RecipeData("Ensalada César", "Entrante", 15, false)
        )

        _uiState.update { currentState ->
            currentState.copy(recipies = items)
        }
    }

    fun modifyFavorite(name: String) {
        _uiState.update { currentState ->
            currentState.copy(
                recipies = currentState.recipies.map { item ->
                    if (item.name == name) item.copy(favorite = !item.favorite)
                    else item
                }
            )
        }
    }
}