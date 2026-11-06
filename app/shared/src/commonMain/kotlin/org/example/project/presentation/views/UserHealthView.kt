package org.example.project.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.example.project.presentation.viewModels.UserHealthVM

@Composable
fun UserHealthView(viewModel: UserHealthVM) {
    val (userHealth) = viewModel.uiState.collectAsState().value

    Column(
    ) {
        Text(text = "Peso: ${userHealth?.peso}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Altura: ${userHealth?.altura}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Pasos dados: ${userHealth?.nPasos}", style = MaterialTheme.typography.titleMedium)
        Text(
            text = "Objetivo cumplido: ${userHealth?.objetivo()}",
            style = MaterialTheme.typography.titleMediumEmphasized
        )
        Text(
            text = "IMC: ${userHealth?.calcIMC()}",
            style = MaterialTheme.typography.titleMedium
        )

        Button(onClick = {
            viewModel.sumarPasos(1000)
        }) { Text("Sumar Pasos") }
    }
}