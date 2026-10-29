package org.example.project.presentation.mapper

import org.example.project.models.RecipeData
import org.example.project.presentation.states.RecipeState

fun RecipeData.toState() : RecipeState {
    return RecipeState(
        name = this.name,
        category = this.category,
        minutes = this.minutes,
        favorite = if (this.favorite) "⭐" else "",
        isFast = if (this.isFast()) "FAST RECIPE" else ""
    )
}