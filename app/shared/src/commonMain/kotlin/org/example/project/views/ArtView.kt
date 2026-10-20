package org.example.project.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.models.ArtData
import org.example.project.viewModels.ArtVM

@Composable
fun ArtView(viewModel: ArtVM = viewModel()) {
    val (items, selectedItem) = viewModel.uiState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp, 5.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(items) { item -> itemCard(item, onClick = { viewModel.selectItem(item) }) }
        }
    }

    selectedItem?.let { item ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .size(200.dp, 150.dp)
            ) {
                Text(
                    text = item.title,
                    modifier = Modifier
                        .padding(5.dp)
                )
                IconButton(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(5.dp)
                        .defaultMinSize(),
                    onClick = { viewModel.clearSelection() }) {
                    Text(
                        modifier = Modifier
                            .padding(5.dp, 0.dp),
                        text = "X"
                    )
                }
                Column(modifier = Modifier.padding(40.dp, 15.dp)) {
                    Text(item.description)
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(5.dp),
                        thickness = 2.dp
                    )
                    Text(item.creationYear.toString())
                }
            }
        }

    }
}

@Composable
fun itemCard(item: ArtData, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(item.title)
            Text(item.artist)
        }
    }
}