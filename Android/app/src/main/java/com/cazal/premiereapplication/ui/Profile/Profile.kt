package com.cazal.premiereapplication.Profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cazal.premiereapplication.R


@Composable
fun Profile(windowClass: WindowSizeClass, navController: NavHostController) {
    /*Si téléphone vertical*/
    when(windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
                InformationsPrincipals()
                Contact()
                Bouton(navController)
            }
        }
        /*Si téléphone horizontale*/
        else -> {
            Row (horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
                InformationsPrincipals()
                Column (modifier = Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
                    Contact()
                    Bouton(navController)
                }
            }
        }
    }
}

@Composable
fun InformationsPrincipals() { Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
    ImageProfil()
    Spacer(Modifier.height(10.dp))
    Nom()
    Spacer(Modifier.height(10.dp))
    Titre()
}
}

@Composable
fun ImageProfil() {
    Image(
        painterResource(id = R.drawable.t_l_chargement),
        contentDescription = "Photo de profil",
        modifier = Modifier
            .size(160.dp)
            .clip(CircleShape)
            .border(
                BorderStroke(2.dp, Color.Black),
                CircleShape
            ),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun Nom() {
    Text(
        text = "Victor Cazal",
        fontSize = 30.sp
    )
}

@Composable
fun Titre() {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Étudiant en informatique")
        Text(text = "École d'ingénieur ISIS - INU Champolion", fontStyle = FontStyle.Italic)
    }
}

@Composable
fun Contact() {
    /*Column (horizontalAlignment = Alignment.CenterHorizontally) {*/
    LazyVerticalGrid(modifier = Modifier.width(400.dp), columns = GridCells.Fixed(4)) {
        item {
            Image(
                painterResource(id = R.drawable.gmail_icon__2013_2020__svg),
                contentDescription = "Icon mail",
                modifier = Modifier
                    .size(20.dp)
            )
        }
        item(span = { GridItemSpan(3) }) {
            Text(text = "victorcazal59@gmail.com")
        }
        item {
            Image(
                painterResource(id = R.drawable._74857),
                contentDescription = "Icon mail",
                modifier = Modifier
                    .size(20.dp)
            )
        }
        item(span = { GridItemSpan(3) }) {
            Text(text = "url linkdedIn")
        }

    }
}

@Composable
fun Bouton(navController: NavHostController) {
    Button(onClick = { navController.navigate("Navigation") }) {
        Text(text = "Démarrer")

    }
}