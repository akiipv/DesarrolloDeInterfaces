package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.models.*
import org.example.project.viewModels.*
import org.example.project.views.*

@Composable
fun App() {
    MaterialTheme {
        /*val viewModel: BaseViewModel = viewModel { BaseViewModel() }
        BaseScreen(viewModel = viewModel)*/

        /* Proyecto 0
        val viewModel: UserHealthVM = viewModel { UserHealthVM() }
        UserHealthView(viewModel = viewModel) */

        /* Proyecto 1
        val viewModel: ArtVM = viewModel { ArtVM() }
        ArtView(viewModel = viewModel) */

        /* Proyecto 2
        val viewModel: EstateVM = viewModel { EstateVM() }
        EstateView(viewModel = viewModel) */

        /* Proyecto 3
        val viewModel: StudentVM = viewModel() { StudentVM() }
        StudentView(viewModel = viewModel) */

        /* Proyecto 4
        val viewModel: MovieVM = viewModel() { MovieVM() }
        MovieView(viewModel = viewModel) */

        /* Proyecto 5
        val viewModel: RecipeVM = viewModel() { RecipeVM() }
        RecipeView(viewModel = viewModel) */
    }
}