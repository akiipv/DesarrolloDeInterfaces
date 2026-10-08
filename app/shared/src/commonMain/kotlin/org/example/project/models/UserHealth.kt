package org.example.project.models

data class UserHealth(
    var peso: Double,
    var altura: Double,
    var nPasos: Int
) {
    fun calcIMC(peso: Double, altura: Double): Double = (peso / altura * altura)
    fun objetivo(nPasos: Int): Boolean = (nPasos >= 10000)
}

