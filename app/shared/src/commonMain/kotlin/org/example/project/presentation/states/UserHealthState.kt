package org.example.project.presentation.states

data class UserHealthState (
    val peso: Double,
    val altura: Double,
    val nPasos: Int,
    val IMC: Int,
    val objetivo: Boolean
)