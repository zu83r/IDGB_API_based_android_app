package com.example.igdb_api_based_android_app.retrofit

import com.example.igdb_api_based_android_app.model.GameResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface IGDBApiService {
    @Headers("Accept: application/json")
    @POST("games")
    suspend fun getGames(@Body body: String): List<GameResponse>
}