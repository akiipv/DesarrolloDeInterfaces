package org.example.project.states

import org.example.project.models.RecipeData

data class RecipeState (
    val recipies: List<RecipeData> = emptyList()
)