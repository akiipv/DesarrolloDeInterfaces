package org.example.project.data.mapper

import org.example.project.data.dto.StudentDto
import org.example.project.data.dto.UserHealthDto
import org.example.project.models.StudentData
import org.example.project.models.UserHealth

fun UserHealthDto.toModel() : UserHealth {
    return UserHealth(
        peso = this.peso,
        altura = this.altura,
        nPasos = this.nPasos
    )
}

fun UserHealth.toDto() : UserHealthDto {
    return UserHealthDto(
        peso = this.peso,
        altura = this.altura,
        nPasos = this.nPasos
    )
}