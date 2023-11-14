package com.cazal.premiereapplication.ui.Navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cazal.premiereapplication.Films.films
import com.cazal.premiereapplication.ui.Films.detailSerie
import com.cazal.premiereapplication.ui.Films.detailsActeur
import com.cazal.premiereapplication.ui.Films.detailsFilm
import com.cazal.premiereapplication.ui.Films.personnes
import com.cazal.premiereapplication.ui.Films.rechercheFilm
import com.cazal.premiereapplication.ui.Films.series

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navigation (windowClass : WindowSizeClass) {

    val navController = rememberNavController()

    var faitUneRecherche by remember { mutableStateOf(false) }
    var recherche by remember { mutableStateOf("") }

    when(windowClass.widthSizeClass) {
        /*Si téléphone vertical*/
        WindowWidthSizeClass.Compact -> {

            Scaffold (
                topBar = {
                    TopAppBar(
                        title = {

                            if(!faitUneRecherche) {
                                Text(text = "Titre")
                            } else {
                                TextField(
                                    value = recherche,
                                    onValueChange = {recherche = it},
                                    placeholder = { Text(text = "Rechercher un film")})
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    faitUneRecherche = !faitUneRecherche
                                    if(!faitUneRecherche) {
                                        if(recherche.isNotEmpty()) {
                                            navController.navigate("RechercheFilm")
                                        }
                                    }
                                }) {
                                Icon(Icons.Filled.Search, contentDescription = null)
                            }
                        }
                    )
                },
                bottomBar = {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = false,
                            onClick = { navController.navigate("DerniersFilms") },
                            icon = { Icon(Icons.Filled.PlayArrow, contentDescription = null) },
                            label = { Text(text = "Films")}
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { navController.navigate("Series") },
                            icon = { Icon(Icons.Filled.PlayArrow, contentDescription = null) },
                            label = { Text(text = "Séries")}
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { navController.navigate("Personnes") },
                            icon = { Icon(Icons.Filled.PlayArrow, contentDescription = null) },
                            label = { Text(text = "Acteurs")}
                        )
                    }
                }
            ){
                    contentPadding ->
                NavHost(modifier = Modifier.padding(contentPadding), navController = navController, startDestination = "DerniersFilms") {
                    composable("DerniersFilms") { films(windowClass, navController) }
                    composable("Series") { series(windowClass, navController) }
                    composable("Personnes") { personnes(windowClass, navController)}
                    composable("DetailsFilm/{filmId}") {detailsFilm(windowClass, navController)}
                    composable("DetailsActeur/{acteurId}") { detailsActeur(windowClass, navController)}
                    composable("RechercheFilm") { rechercheFilm(recherche, windowClass, navController)}
                    composable("DetailsSerie/{serieId}") { detailSerie(windowClass, navController)}
                }
            }

        }
        else -> {
            Row {
                NavigationRail {
                    Column (
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceEvenly){
                        NavigationRailItem(
                            selected = true,
                            onClick = { navController.navigate("DerniersFilms") },
                            icon = {Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null) },
                            label = {Text(text = "Films")})
                        NavigationRailItem(
                            selected = true,
                            onClick = { navController.navigate("Series") },
                            icon = {Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null) },
                            label = {Text(text = "Séries")})
                        NavigationRailItem(
                            selected = true,
                            onClick = { navController.navigate("Personnes") },
                            icon = {Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null) },
                            label = {Text(text = "Acteurs")})
                    }
                }
                NavHost(modifier = Modifier.fillMaxHeight(), navController = navController, startDestination = "DerniersFilms") {
                    composable("DerniersFilms") { films(windowClass, navController) }
                    composable("Series") { series(windowClass, navController) }
                    composable("Personnes") { personnes(windowClass, navController)}
                    composable("DetailsFilm/{filmId}") {detailsFilm(windowClass, navController)}
                    composable("DetailsActeur/{acteurId}") { detailsActeur(windowClass, navController)}
                    composable("RechercheFilm") { rechercheFilm(recherche, windowClass, navController) }
                    composable("DetailsSerie/{serieId}") { detailSerie(windowClass, navController)}
                }
            }


            /*Scaffold (
                topBar = {
                    TopAppBar(
                        title = {
                            if(!faitUneRecherche) {
                                Text(text = "Titre")
                            } else {
                                TextField(
                                    value = recherche,
                                    onValueChange = {recherche = it})
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    faitUneRecherche = !faitUneRecherche
                                    if(!faitUneRecherche) {
                                        if(recherche.isNotEmpty()) {
                                            navController.navigate("RechercheFilm")
                                        }
                                    }
                                }) {
                                Icon(Icons.Filled.Search, contentDescription = null)
                            }
                        }
                    )
                },
                bottomBar = {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = false,
                            onClick = { navController.navigate("DerniersFilms") },
                            icon = { Icon(Icons.Filled.PlayArrow, contentDescription = null) },
                            label = { Text(text = "Films")}
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { navController.navigate("Series") },
                            icon = { Icon(Icons.Filled.PlayArrow, contentDescription = null) },
                            label = { Text(text = "Séries")}
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { navController.navigate("Personnes") },
                            icon = { Icon(Icons.Filled.PlayArrow, contentDescription = null) },
                            label = { Text(text = "Acteurs")}
                        )
                    }
                }
            ){
                    contentPadding ->
                NavHost(modifier = Modifier.padding(contentPadding), navController = navController, startDestination = "DerniersFilms") {
                    composable("DerniersFilms") { films(windowClass, navController) }
                    composable("Series") { series(windowClass) }
                    composable("Personnes") { personnes(windowClass, navController)}
                    composable("DetailsFilm/{filmId}") {detailsFilm(windowClass, navController)}
                    composable("DetailsActeur/{acteurId}") { detailsActeur(windowClass, navController)}
                    composable("RechercheFilm") { rechercheFilm(windowClass, navController) }
                }
            }*/
        }
    }
}