package com.cazal.premiereapplication.ui.Films

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.cazal.premiereapplication.ui.compsant.carteHorizontal
import com.cazal.premiereapplication.ui.compsant.carteVertical

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun series(windowClass : WindowSizeClass, navController : NavHostController) {

    val seriesViewModel : SeriesViewModel = viewModel()

    val series = seriesViewModel.series.collectAsState()

    when(windowClass.widthSizeClass) {
        /*Si téléphone vertical*/
        WindowWidthSizeClass.Compact -> {

            /*Liste des série*/
            LazyVerticalGrid (
                columns = GridCells.Fixed(1),
                modifier = Modifier.background(Color.Black)) {
                items(series.value) { serie ->
                    /*Carte d'une série*/
                    carteVertical(
                        navController = navController,
                        id = "DetailsSerie/" + serie.id,
                        path = serie.poster_path,
                        titre = serie.name)
                }
            }

        }
        else -> {

            LazyHorizontalGrid (
                rows = GridCells.Fixed(1),
                modifier = Modifier.background(Color.Black)) {
                items(series.value) { serie ->
                    carteHorizontal(
                        navController = navController,
                        id = "DetailsSerie/" + serie.id,
                        path = serie.poster_path,
                        titre = serie.name)
                }
            }

        }
    }
}