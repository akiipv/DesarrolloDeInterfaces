package org.example.project.models

data class ArtData(
    val identifier: Int,
    val title: String,
    val artist: String,
    val creationYear: Int,
    val description: String
) {
    fun isItOld(): Boolean = creationYear <= 1900
}