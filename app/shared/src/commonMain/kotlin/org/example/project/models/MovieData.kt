package org.example.project.models

import kotlin.time.Duration

data class MovieData(
    val title: String,
    val genre: String,
    val duration: Duration
)