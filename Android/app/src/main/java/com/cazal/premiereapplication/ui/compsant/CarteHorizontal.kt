package com.cazal.premiereapplication.ui.compsant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun carteHorizontal (navController: NavHostController, id: String, path: String, titre: String) {

    Surface (
        color = Color.Gray.copy(0.15f),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
        .padding(horizontal = 20.dp, vertical = 10.dp)
        .fillMaxHeight()
        .width(250.dp),
        onClick = {navController.navigate(id)}) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()){
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w780/" + path,
                    contentDescription = "Affiche du filme",
                    modifier = Modifier
                        .size(250.dp)
                        .padding(top = 10.dp))
                Text(
                    text = titre,
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp, end = 10.dp),
                    textAlign = TextAlign.Center)
            }
    }
}