package org.example.project.data.mapper

import org.example.project.data.dto.StudentDto
import org.example.project.models.StudentData

fun StudentDto.toModel() : StudentData {
    return StudentData(
        name = this.name,
        theory = this.theory,
        practice = this.practice
    )
}

fun StudentData.toDto() : StudentDto {
    return StudentDto(
        name = this.name,
        theory = this.theory,
        practice = this.practice
    )
}