package org.example.project.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.viewModels.UserHealthVM

@Composable
fun UserHealthView(viewModel: UserHealthVM) {
    val (userHealth) = viewModel.uiState.collectAsState().value

    Column(
    ) {
        Text(text = "Peso: ${userHealth?.peso}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Altura: ${userHealth?.altura}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Pasos dados: ${userHealth?.nPasos}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Objetivo cumplido: ${userHealth?.objetivo(userHealth.nPasos)}", style = MaterialTheme.typography.titleMediumEmphasized)
        Text(text = "IMC: ${userHealth?.calcIMC(userHealth.peso, userHealth.altura)}", style = MaterialTheme.typography.titleMedium)

        Button(onClick = {
            viewModel.sumarPasos(1000)
        }) { Text("Sumar Pasos") }
    }
}