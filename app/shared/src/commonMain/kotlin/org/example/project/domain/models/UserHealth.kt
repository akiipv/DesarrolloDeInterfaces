package org.example.project.models

data class UserHealth(
    val peso: Double,
    val altura: Double,
    val nPasos: Int
) {
    fun calcIMC(): Double = (peso / altura * altura)
    fun objetivo(): Boolean = (nPasos >= 10000)
}

