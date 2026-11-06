package org.example.project.data.dto

import kotlin.time.Duration

data class MovieDto (
    val title: String,
    val genre: String,
    val duration: Duration
)