package org.example.project.presentation.mapper

import org.example.project.data.dto.UserHealthDto
import org.example.project.models.UserHealth
import org.example.project.presentation.states.UserHealthState

fun UserHealth.toState() : UserHealthState {
    return UserHealthState(
        peso = this.peso,
        altura = this.altura,
        nPasos = this.nPasos,
        IMC = this.calcIMC(),
        objetivo = this.objetivo(nPasos)
    )
}
