package org.example.project.presentation.states

import org.example.project.models.EstateData

data class EstateScreenState(
    val items: List<EstateData> = emptyList()
)