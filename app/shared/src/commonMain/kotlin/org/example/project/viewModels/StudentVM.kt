package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.StudentData
import org.example.project.states.StudentState

class StudentVM : ViewModel() {
    private val _uiState = MutableStateFlow(StudentState())
    val uiState: StateFlow<StudentState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val items = listOf(
            StudentData("Alejandro", 5.00, 6.70),
            StudentData("Isa", 6.70, 3.00),
            StudentData("Jivars", 8.00, 4.00)
        )

        _uiState.update { currentState ->
            currentState.copy(items = items)
        }
    }

    fun addStudent(name: String?, practice: Double?, theory: Double?) {
        if (!name.isNullOrEmpty() || practice != null || theory != null) {
            val student = StudentData(name!!, theory!!, practice!!)
            _uiState.update {
                    currentState -> currentState.copy(items = currentState.items.plus(student).sortedBy { item -> item.name })
            }
        }


    }
}