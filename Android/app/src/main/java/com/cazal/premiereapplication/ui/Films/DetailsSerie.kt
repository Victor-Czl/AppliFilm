package com.cazal.premiereapplication.ui.Films

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.cazal.premiereapplication.ui.compsant.DetailsFilmOuSerie

@Composable
fun detailSerie(windowClass: WindowSizeClass, navController: NavHostController) {

    val detailsSerieViewModel : DetailsSerieViewModel = viewModel()
    val detailsSerie = detailsSerieViewModel.detailsSerie.collectAsState()
    
    DetailsFilmOuSerie(
        titre = detailsSerie.value.name,
        backdropPath = detailsSerie.value.backdrop_path ,
        tagline = detailsSerie.value.tagline,
        genres = detailsSerie.value.genres,
        posterPath = detailsSerie.value.poster_path,
        overview = detailsSerie.value.overview,
        credits = detailsSerie.value.credits,
        navController = navController
    )

}