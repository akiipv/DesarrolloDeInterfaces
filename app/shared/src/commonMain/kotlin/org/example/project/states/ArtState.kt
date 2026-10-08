package org.example.project.states

import org.example.project.models.ArtData

data class ArtState(
    val items: List<ArtData> = emptyList(),
    val selectedItem: ArtData? = null
)