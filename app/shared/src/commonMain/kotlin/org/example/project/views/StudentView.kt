package org.example.project.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.example.project.models.StudentData
import org.example.project.viewModels.StudentVM

@Composable
fun StudentView(viewModel: StudentVM) {
    val (items) = viewModel.uiState.collectAsState().value

    val inputName = rememberTextFieldState()
    val inputTheory = rememberTextFieldState()
    val inputPractice = rememberTextFieldState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Añadir alumno",
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedTextField(
                    state = inputName,
                    lineLimits = TextFieldLineLimits.SingleLine,
                    label = { Text("Nombre del alumno") },
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    state = inputPractice,
                    lineLimits = TextFieldLineLimits.SingleLine,
                    label = { Text("Nota práctica") },
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    state = inputTheory,
                    lineLimits = TextFieldLineLimits.SingleLine,
                    label = { Text("Nota teórica") },
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { viewModel.addStudent(
                        inputName.text.toString(),
                        inputPractice.text.toString().toDoubleOrNull(),
                        inputTheory.text.toString().toDoubleOrNull())
                    },
                ) { Text("Guardar") }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier
                .padding(15.dp)
        ) {
            items(items) { item ->
                cardStudents(item)
            }
        }
    }
}

@Composable
fun cardStudents(Student: StudentData) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .widthIn(220.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(text = Student.name.replaceFirstChar { it.uppercase() },
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
            HorizontalDivider(
                modifier = Modifier.width(55.dp),
                color = Color.Black,
                thickness = 2.dp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Nota teórica: ${Student.theory}")
            Text(text = "Nota práctica: ${Student.practice}")
            Text(text = "Media: ${Student.average()}")
            Spacer(modifier = Modifier.height(5.dp))
            Badge(containerColor = if (Student.doTheyPass()) Color.Green else Color.Red,
                modifier = Modifier.padding(8.dp)
            )
            { Text(text = if (Student.doTheyPass()) "Ha superado la asignatura" else "No ha superado la asignatura") }
        }
    }
}