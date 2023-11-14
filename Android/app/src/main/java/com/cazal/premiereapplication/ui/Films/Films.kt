package com.cazal.premiereapplication.Films

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
import com.cazal.premiereapplication.ui.Films.FilmsViewModel
import com.cazal.premiereapplication.ui.compsant.carteHorizontal
import com.cazal.premiereapplication.ui.compsant.carteVertical

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun films(windowClass: WindowSizeClass, navController: NavHostController) {

        val derniersFilmsViewModel : FilmsViewModel = viewModel()

        val films = derniersFilmsViewModel.films.collectAsState()

        when(windowClass.widthSizeClass) {
            /*Si téléphone vertical*/
            WindowWidthSizeClass.Compact -> {

                /*Listes des filmes*/
                LazyVerticalGrid (
                    columns = GridCells.Fixed(1),
                    modifier = Modifier.background(Color.Black)) {
                    items(films.value) { film ->
                        /*Carte d'un filme*/
                        carteVertical(
                            navController = navController,
                            id = "DetailsFilm/" + film.id,
                            path = film.poster_path,
                            titre = film.title)
                    }
                }
            }
            else -> {

                /*Listes des filmes*/
                LazyHorizontalGrid (
                    rows = GridCells.Fixed(1),
                    modifier = Modifier.background(Color.Black)) {
                    items(films.value) { film ->
                        /*Carte d'un filme*/
                        carteHorizontal(
                            navController = navController,
                            id = "DetailsFilm/" + film.id,
                            path = film.poster_path,
                            titre = film.title )
                    }
                }
            }
        }
}
