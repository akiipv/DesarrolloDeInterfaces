package org.example.project.models

data class RecipeData (
    val name: String,
    val category: String,
    val minutes: Int,
    val favorite: Boolean
) {
    fun isFast(): Boolean = minutes <= 20
}