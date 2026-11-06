package org.example.project.presentation.states

import org.example.project.models.UserHealth

data class UserHealthScreenState(
    val userHealth: UserHealth? = UserHealth(80.00, 1.50, 0)
)