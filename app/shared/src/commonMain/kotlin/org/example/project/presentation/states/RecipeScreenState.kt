package org.example.project.presentation.states

import org.example.project.models.RecipeData

data class RecipeScreenState (
    val recipies: List<RecipeData> = emptyList()
)