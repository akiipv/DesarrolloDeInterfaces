package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.example.project.states.UserHealthState

class UserHealthVM : ViewModel() {
    private val _uiState = MutableStateFlow(UserHealthState())
    val uiState: StateFlow<UserHealthState> = _uiState.asStateFlow()

    fun sumarPasos(pasos: Int) {
        val healthAct = _uiState.value.userHealth
        val newHealth = healthAct?.copy(nPasos = healthAct.nPasos + pasos)

        _uiState.value = _uiState.value.copy(userHealth = newHealth)
    }
}