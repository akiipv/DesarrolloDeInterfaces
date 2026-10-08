package org.example.project.states

import org.example.project.models.EstateData

data class EstateState(
    val items: List<EstateData> = emptyList()
)