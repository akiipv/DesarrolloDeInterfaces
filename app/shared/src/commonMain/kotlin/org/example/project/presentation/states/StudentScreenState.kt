package org.example.project.presentation.states

import org.example.project.models.StudentData

data class StudentScreenState(
    val items: List<StudentData> = emptyList()
)
