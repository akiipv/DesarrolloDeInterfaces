package org.example.project.presentation.states

data class ArtState (
    val identifier: Int,
    val title: String,
    val artist: String,
    val creationYear: Int,
    val description: String,
    val old: Boolean
)