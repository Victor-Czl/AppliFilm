package com.cazal.premiereapplication.ui.compsant

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.cazal.premiereapplication.Models.Credits
import com.cazal.premiereapplication.Models.Genre

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsFilmOuSerie (
    titre : String,
    backdropPath : String,
    tagline : String,
    genres : List<Genre>,
    posterPath : String,
    overview : String,
    credits : Credits,
    navController : NavHostController) {

    Column (
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {

        /*Titre du filme*/
        Row(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center) {
            Text(
                text = titre,
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                color = Color.White
            )
        }

        /*Poster fond de toile*/
        Row(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.Center) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w780/" + backdropPath,
                contentDescription = "Poster fond de toile"
            )
        }

        /*Phrase d'acroche*/
        Row(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.Center){
            Text(
                text = tagline,
                color = Color.White,
                fontSize = 20.sp
            )
        }

        /*Genre du film*/
        Row(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
                .padding(vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            var genresTemp : String = ""
            genres.forEach { genre -> genresTemp += genre.name + " - " }
            Text(
                text = genresTemp,
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp))
        }

        /*Affiche et synopsis*/
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)) {

            /*Affiche du filme*/
            Column (verticalArrangement = Arrangement.Center){
                AsyncImage( model = "https://image.tmdb.org/t/p/w780/" + posterPath,
                    contentDescription = "Affiche du filme",
                    modifier = Modifier.size(150.dp))
            }

            /*Synopsis*/
            Column (
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = "Synopsis",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 15.dp, end = 30.dp))
                Text(
                    text = overview,
                    style = TextStyle(textAlign = TextAlign.Justify),
                    modifier = Modifier.padding(end = 30.dp))
            }
        }

        /*Distribution*/
        Row (modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
            horizontalArrangement = Arrangement.Center) {
            Text(text = "Distribution",
                color = Color.White,
                fontSize = 20.sp)
        }

        Row(modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .background(Color.Black)
            .padding(16.dp)) {
            credits.cast.forEach { cast ->
                Surface(
                    color = Color.Gray.copy(0.15f),
                    shape = MaterialTheme.shapes.medium,
                    onClick = {navController.navigate("DetailsActeur/" + cast.id)}) {
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally,){
                        AsyncImage(modifier = Modifier.size(300.dp),
                            model = "https://image.tmdb.org/t/p/w780/" + cast.profile_path,
                            contentDescription = null)
                        Text(text = cast.name, color = Color.White, fontSize = 15.sp, modifier = Modifier.padding(vertical = 8.dp))
                        Text(text = cast.character, color = Color.White, fontSize = 15.sp)
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}