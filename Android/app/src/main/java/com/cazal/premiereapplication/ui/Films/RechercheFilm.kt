package com.cazal.premiereapplication.ui.Films

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.cazal.premiereapplication.ui.compsant.carteHorizontal
import com.cazal.premiereapplication.ui.compsant.carteVertical


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rechercheFilm(recherche : String, windowClass: WindowSizeClass, navController: NavHostController) {

    val rechercheFilmViewModel = RechercheFilmViewModel(recherche)
    val resultats = rechercheFilmViewModel.resultats.collectAsState()

    when(windowClass.widthSizeClass) {
        /*Si téléphone vertical*/
        WindowWidthSizeClass.Compact -> {

            /*Listes des filmes*/
            LazyVerticalGrid (
                columns = GridCells.Fixed(1),
                modifier = Modifier.background(Color.Black)) {
                items(resultats.value) { resultat ->
                    /*Carte d'un filme*/
                    carteVertical(
                        navController = navController,
                        id = "DetailsFilm/" + resultat.id,
                        path = resultat.poster_path,
                        titre = resultat.title)
                }
            }
        }
        else -> {

            /*Listes des filmes*/
            LazyHorizontalGrid (
                rows = GridCells.Fixed(1),
                modifier = Modifier.background(Color.Black)) {
                items(resultats.value) { resultat ->
                    /*Carte d'un filme*/
                    carteHorizontal(
                        navController = navController,
                        id = "DetailsFilm/" + resultat.id,
                        path = resultat.poster_path,
                        titre = resultat.title )
                }
            }
        }
    }
}
