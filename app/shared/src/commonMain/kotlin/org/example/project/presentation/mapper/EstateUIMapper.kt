package org.example.project.presentation.mapper

import org.example.project.data.dto.EstateDto
import org.example.project.models.EstateData
import org.example.project.presentation.states.EstateState

fun EstateData.toState() : EstateState {
    return EstateState(
        id = this.id,
        name = this.name,
        type = this.type,
        hectares = this.hectares,
        needsWater = this.needsWater,
        waterLiter = this.waterNeeded()
    )
}
