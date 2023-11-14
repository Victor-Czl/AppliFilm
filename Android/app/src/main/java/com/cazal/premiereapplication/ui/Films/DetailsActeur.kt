package com.cazal.premiereapplication.ui.Films

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun detailsActeur (windowClass: WindowSizeClass, navController: NavHostController) {

    val detailsActeurViewModel : DetailsActeurViewModel = viewModel()
    val detailsActeur = detailsActeurViewModel.detailsActeur.collectAsState()

    Column {
        Text(text = detailsActeur.value.name)
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w780/" + detailsActeur.value.profile_path,
            contentDescription = "Profile de l'acteur")
        Text(text = detailsActeur.value.birthday)
        Text(text = detailsActeur.value.biography)
        Text(text = detailsActeur.value.known_for_department)
    }

}