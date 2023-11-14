package com.cazal.premiereapplication.ui.compsant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
fun carteVertical (navController: NavHostController, id: String, path: String, titre: String) {

    Surface (
        color = Color.Gray.copy(0.15f),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(20.dp),
        onClick = { navController.navigate(id)} ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 30.dp)) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w780/" + path,
                contentDescription = "Affiche du filme",
                modifier = Modifier.padding(bottom = 10.dp))
            Text(
                text = titre,
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp))
        }
    }

}