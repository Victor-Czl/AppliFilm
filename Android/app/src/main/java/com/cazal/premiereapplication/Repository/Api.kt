package com.cazal.premiereapplication.Repository

import com.cazal.premiereapplication.Models.DetailsActeur
import com.cazal.premiereapplication.Models.Films
import com.cazal.premiereapplication.Models.Acteurs
import com.cazal.premiereapplication.Models.Series
import com.cazal.premiereapplication.Models.DetailsFilm
import com.cazal.premiereapplication.Models.DetailsSerie
import com.cazal.premiereapplication.Models.ResultatsRechercheFilm
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*Interface : obtenir les derniers films*/
interface apiFilms {
    @GET("trending/movie/week?language=fr")
    suspend fun derniersFilms(@Query("api_key") api_key: String): Films
}

/*Interface : obtenir les dernières série*/
interface apiSeries {
    @GET("trending/tv/week?language=fr")
    suspend fun series(@Query("api_key") api_key: String): Series
}

/*Interface : obtenir les derniers acteurs*/
interface apiPersonnes {
    @GET("trending/person/week?language=fr")
    suspend fun personnes(@Query("api_key") api_key: String): Acteurs
}

/*Interface : obtenir les détails d'un film*/
interface apiDetailsFilm {
    @GET("movie/{filmId}?append_to_response=credits&language=fr")
    suspend fun detailsFilm(@Path("filmId") filmId : String, @Query("api_key") api_key: String): DetailsFilm
}

/*Interface : obtenir les détails d'un acteur*/
interface apiDetailsActeur {
    @GET("person/{acteurId}?append_to_response=credits&language=fr")
    suspend fun detailsActeur(@Path("acteurId") acteurId : String, @Query("api_key") api_key : String): DetailsActeur
}

/*Interface : obtenir les détails d'une série*/
interface apiDetailsSerie {
    @GET("tv/{serieId}?append_to_response=credits&language=fr")
    suspend fun detailsSerie(@Path("serieId") serieId : String, @Query("api_key") api_key : String): DetailsSerie
}

/*Interface : rechercher un film*/
interface apiRechercheFilm {
    @GET("search/movie")
    suspend fun rechercheFilm(@Query ("api_key") api_key : String, @Query ("query") recherche : String) : ResultatsRechercheFilm
}



