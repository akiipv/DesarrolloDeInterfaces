package org.example.project.states

import org.example.project.models.StudentData

data class StudentState(
    val items: List<StudentData> = emptyList()
)
