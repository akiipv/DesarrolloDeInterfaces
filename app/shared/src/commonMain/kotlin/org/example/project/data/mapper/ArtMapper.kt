package org.example.project.data.mapper

import org.example.project.data.dto.ArtDto
import org.example.project.models.ArtData

fun ArtDto.toModel() : ArtData {
    return ArtData(
        identifier = this.id,
        title = this.title,
        artist = this.artist,
        creationYear = this.creationYear,
        description = this.description
    )
}

fun ArtData.toDto() : ArtDto {
    return ArtDto(
        id = this.identifier,
        title = this.title,
        artist = this.artist,
        creationYear = this.creationYear,
        description = this.description
    )
}