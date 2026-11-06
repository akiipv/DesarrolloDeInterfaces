package org.example.project.presentation.states

data class EstateState (
    val id: Int,
    val name: String,
    val type: String,
    val hectares: Int,
    val needsWater: Boolean,
    val waterLiter: Int
)