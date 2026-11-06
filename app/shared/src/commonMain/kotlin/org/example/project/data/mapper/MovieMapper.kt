package org.example.project.data.mapper

import org.example.project.data.dto.MovieDto
import org.example.project.models.MovieData

fun MovieDto.toModel() : MovieData {
    return MovieData(
        title = this.title,
        genre = this.genre,
        duration = this.duration
    )
}

fun MovieData.toDto() : MovieDto {
    return MovieDto(
        title = this.title,
        genre = this.genre,
        duration = this.duration
    )
}