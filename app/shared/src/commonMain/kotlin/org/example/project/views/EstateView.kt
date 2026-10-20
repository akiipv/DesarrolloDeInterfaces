package org.example.project.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.project.viewModels.EstateVM
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.models.EstateData

@Composable
fun EstateView(viewModel: EstateVM) {
    val (items) = viewModel.uiState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyRow(
            contentPadding = PaddingValues(15.dp)
        ) {
            items(items) { item ->
                EstateCard(item, onclick = {
                    viewModel.modifyWaterNeed(item.id)
                })
            }

        }

        Card(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = "Resumen",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 2.dp,
                    color = MaterialTheme.colorScheme.outline
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text("· Parcelas activas para riego﹕ ")
                LazyRow {
                    items(items) { item -> if (!item.needsWater) Text("${item.name} ") }
                }
            }
        }
    }
}

@Composable
fun EstateCard(item: EstateData, onclick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(400.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = item.name.replaceFirstChar { it.uppercase() },
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text("· Tipo de cultivo﹕ ${item.type}")
            Text("· Superficie en hectareas﹕ ${item.hectares}")
            Row(
                modifier = Modifier
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (item.needsWater) "Necesita riego" else "Activa para el riego",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                Button(
                    onClick = onclick, modifier = Modifier
                        .size(100.dp, 30.dp)
                ) {
                    Text(
                        text = "Cambiar",
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}