
package com.example.igdb_api_based_android_app.repository

import com.example.igdb_api_based_android_app.model.GameResponse
import com.example.igdb_api_based_android_app.retrofit.IGDBApiService

class GameRepository(private val api: IGDBApiService) {
    suspend fun fetchGames(): List<GameResponse> {
        val query = "fields id,name,summary; limit 20;"
        return api.getGames(query)
    }
}