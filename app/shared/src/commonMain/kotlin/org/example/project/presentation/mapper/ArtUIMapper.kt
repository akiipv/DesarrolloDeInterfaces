package org.example.project.presentation.mapper

import org.example.project.models.ArtData
import org.example.project.presentation.states.ArtScreenState
import org.example.project.presentation.states.ArtState

fun ArtData.toState() : ArtState {
    return ArtState(
        identifier = this.identifier,
        title = this.title,
        artist = this.artist,
        creationYear = this.creationYear,
        description = this.description,
        old = this.isItOld()
    )
}