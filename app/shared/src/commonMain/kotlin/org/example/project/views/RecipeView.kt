package org.example.project.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.models.RecipeData
import org.example.project.viewModels.RecipeVM

@Composable
fun RecipeView(viewModel: RecipeVM) {
    val (items) = viewModel.uiState.collectAsState().value

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*
            el filtrado no se si se puede hacer más facil
            pero en mi mente that was epic
        */
        var yes by remember { mutableStateOf(false) }
        Button(onClick = { yes = !yes },
            colors = ButtonDefaults.buttonColors(Color.Black)) {
            Text("See my favorites")
        }
        LazyRow {
            items(if (yes) items.filter { it.favorite } else items) { item ->
                recipeCard(item) { viewModel.modifyFavorite(item.name) }
            }
        }
    }
}

@Composable
fun recipeCard(item: RecipeData, onClick: () -> Unit) {
    Card(
        modifier = Modifier
        .widthIn(150.dp)
        .padding(15.dp),
        colors = CardDefaults.cardColors(if (item.favorite) Color.Yellow.copy(red = 1f, green = 0.92f, blue = 0.6f) else Color.Unspecified)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Row {
                Text(text = item.name,
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(10.dp))
                if (item.favorite) Text("⭐")
                if (item.isFast()) Text(
                    text = "FAST RECIPE",
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic
                )
            }
            HorizontalDivider(
                modifier = Modifier.width(150.dp),
                thickness = 2.dp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("· Time needed﹕ ${item.minutes} minutes")
            Spacer(modifier = Modifier.height(15.dp))
            Row {
                Button (
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(if (item.favorite) Color(0xFFF2C233) else Color.Unspecified)
                ) {
                    Text(if (item.favorite) "Mark as favorite" else "Unmark")
                }
            }
        }
    }
}