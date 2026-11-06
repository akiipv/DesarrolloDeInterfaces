package org.example.project.presentation.mapper

import org.example.project.data.dto.MovieDto
import org.example.project.models.MovieData
import org.example.project.presentation.states.MovieState

fun MovieData.toState() : MovieState {
    return MovieState(
        title = this.title,
        genre = this.genre,
        duration = this.duration
    )
}