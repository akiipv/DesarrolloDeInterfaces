package org.example.project.states

import org.example.project.models.BasicModel
import org.example.project.models.UserHealth

data class UserHealthState(
    val userHealth: UserHealth? = UserHealth(80.00, 1.50, 0)
)