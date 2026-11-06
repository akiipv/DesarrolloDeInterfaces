package org.example.project.presentation.states

import org.example.project.models.MovieData

data class MovieScreenState(
    val items: List<MovieData> = emptyList()
)