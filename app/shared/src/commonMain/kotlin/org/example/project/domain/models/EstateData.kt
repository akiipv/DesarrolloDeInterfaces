package org.example.project.models

data class EstateData(
    val id: Int,
    val name: String,
    val type: String,
    val hectares: Int,
    val needsWater: Boolean
) {
    fun waterNeeded(): Int = hectares * 1000
}