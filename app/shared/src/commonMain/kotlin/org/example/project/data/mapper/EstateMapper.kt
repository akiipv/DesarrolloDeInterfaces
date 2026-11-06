package org.example.project.data.mapper

import org.example.project.data.dto.EstateDto
import org.example.project.models.EstateData

fun EstateDto.toModel() : EstateData {
    return EstateData(
        id = this.id,
        name = this.name,
        type = this.type,
        hectares = this.hectares,
        needsWater = this.needsWater
    )
}

fun EstateData.toDto() : EstateDto {
    return EstateDto(
        id = this.id,
        name = this.name,
        type = this.type,
        hectares = this.hectares,
        needsWater = this.needsWater
    )
}