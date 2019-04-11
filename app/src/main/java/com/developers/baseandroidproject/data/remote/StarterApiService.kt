package com.developers.baseandroidproject.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  TODO: create contract for the client (Retrofit Client)
 */
interface StarterApiService {

    @GET("now_playing")
    fun getInTheatreMovies(@Query("api_key") apiKey: String)
}