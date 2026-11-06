package org.example.project.presentation.mapper

import org.example.project.data.dto.StudentDto
import org.example.project.models.StudentData
import org.example.project.presentation.states.StudentState

fun StudentData.toState() : StudentState {
    return StudentState(
        name = this.name,
        theory = this.theory,
        practice = this.practice,
        average = this.average(),
        pass = this.doTheyPass()
    )
}