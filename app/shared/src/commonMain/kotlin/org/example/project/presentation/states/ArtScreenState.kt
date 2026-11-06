package org.example.project.presentation.states

import org.example.project.models.ArtData

data class ArtScreenState(
    val items: List<ArtData> = emptyList(),
    val selectedItem: ArtData? = null
)