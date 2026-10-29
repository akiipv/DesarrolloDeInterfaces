package org.example.project.data.mapper

import org.example.project.data.dto.RecipeDto
import org.example.project.models.RecipeData

fun RecipeDto.toModel() : RecipeData {
    return RecipeData(
        name = this.name,
        category = this.category,
        minutes = this.minutes,
        favorite = this.favorite
    )
}

fun RecipeData.toDto() : RecipeDto {
    return RecipeDto(
        name = this.name,
        category = this.category,
        minutes = this.minutes,
        favorite = this.favorite
    )
}