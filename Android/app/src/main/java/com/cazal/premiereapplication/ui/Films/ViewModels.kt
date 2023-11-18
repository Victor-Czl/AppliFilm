package com.cazal.premiereapplication.ui.Films

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.cazal.premiereapplication.Models.DetailsActeur
import com.cazal.premiereapplication.Models.DetailsFilm
import com.cazal.premiereapplication.Models.Film
import com.cazal.premiereapplication.Models.Acteur
import com.cazal.premiereapplication.Models.DetailsSerie
import com.cazal.premiereapplication.Models.ResultatRechercheFilm
import com.cazal.premiereapplication.Models.Serie
import com.cazal.premiereapplication.Repository.apiDetailsActeur
import com.cazal.premiereapplication.Repository.apiDetailsFilm
import com.cazal.premiereapplication.Repository.apiDetailsSerie
import com.cazal.premiereapplication.Repository.apiFilms
import com.cazal.premiereapplication.Repository.apiPersonnes
import com.cazal.premiereapplication.Repository.apiRechercheFilm
import com.cazal.premiereapplication.Repository.apiSeries
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build();

/*View Model : obtenir les derniers films*/
class FilmsViewModel : ViewModel() {

    val api = retrofit.create(apiFilms::class.java)
    val films = MutableStateFlow<List<Film>>(listOf())

    fun getFilms() {
        viewModelScope.launch {
            films.value = api.derniersFilms(api_key = "24714091346b3079a0414fe486ba3858").results
        }
    }

    init {
        getFilms()
    }
}

class SeriesViewModel : ViewModel() {

    val api = retrofit.create(apiSeries::class.java)
    val series = MutableStateFlow<List<Serie>>(listOf())

    fun getSeries() {
        viewModelScope.launch {
            series.value = api.series(api_key = "24714091346b3079a0414fe486ba3858").results
        }
    }

    init {
        getSeries()
    }
}

class PersonnesViewModel : ViewModel() {

    val api = retrofit.create(apiPersonnes::class.java)
    val personnes = MutableStateFlow<List<Acteur>>(listOf())

    fun getPersonnes() {
        viewModelScope.launch {
            personnes.value = api.personnes(api_key = "24714091346b3079a0414fe486ba3858").results
        }
    }

    init {
        getPersonnes()
    }
}

class DetailsFilmViewModel (savedStateHandle: SavedStateHandle): ViewModel() {

    private val filmId : String = checkNotNull(savedStateHandle["filmId"])
    val api = retrofit.create(apiDetailsFilm::class.java)

    val detailsFilm = MutableStateFlow<DetailsFilm>(DetailsFilm())

    fun getDetailsFilm() {
        viewModelScope.launch {
            detailsFilm.value = api.detailsFilm(filmId, api_key = "24714091346b3079a0414fe486ba3858")
        }
    }

    init {
        getDetailsFilm()
    }
}

class DetailsActeurViewModel (savedStateHandle: SavedStateHandle): ViewModel() {

    private val acteurId : String = checkNotNull(savedStateHandle["acteurId"])
    val api = retrofit.create(apiDetailsActeur::class.java)

    val detailsActeur = MutableStateFlow<DetailsActeur>(DetailsActeur())

    fun getDetailsActeur() {
        viewModelScope.launch {
            detailsActeur.value = api.detailsActeur(acteurId, api_key = "24714091346b3079a0414fe486ba3858")
        }
    }

    init {
        getDetailsActeur()
    }
}

class DetailsSerieViewModel (savedStateHandle: SavedStateHandle): ViewModel() {

    private val serieId: String = checkNotNull(savedStateHandle["serieId"])
    val api = retrofit.create(apiDetailsSerie::class.java)

    val detailsSerie = MutableStateFlow<DetailsSerie>(DetailsSerie())

    fun getDetailsSerie() {
        viewModelScope.launch {
            detailsSerie.value = api.detailsSerie(serieId, api_key = "24714091346b3079a0414fe486ba3858")
        }
    }

    init {
        getDetailsSerie()
    }
}

class RechercheFilmViewModel(recherche : String): ViewModel() {

    val api = retrofit.create(apiRechercheFilm::class.java)
    val resultats = MutableStateFlow<List<ResultatRechercheFilm>>(listOf())

    fun getResultatsRechercheFilm(recherche: String) {
        viewModelScope.launch {
            resultats.value = api.rechercheFilm(api_key = "24714091346b3079a0414fe486ba3858", recherche = recherche).results
        }
    }

    init {
        getResultatsRechercheFilm(recherche)
    }
}

class RechercheViewModel(navController : NavHostController) : ViewModel() {

    val faitUneRecherche = mutableStateOf(false)
    val recherche = mutableStateOf("")
    val pageActive = mutableStateOf(navController.currentBackStackEntry?.destination?.route)

}
