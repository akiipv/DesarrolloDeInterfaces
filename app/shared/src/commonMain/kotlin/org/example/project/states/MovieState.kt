package org.example.project.states

import org.example.project.models.MovieData

data class MovieState(
    val items: List<MovieData> = emptyList()
)