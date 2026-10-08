package org.example.project.models

data class StudentData(
    val name: String,
    val theory: Double,
    val practice: Double
) {
    fun average(): Double = (theory * 0.60) + (practice * 0.40)
    fun doTheyPass(): Boolean = average() >= 5
}