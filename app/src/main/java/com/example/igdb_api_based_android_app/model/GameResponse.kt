
package com.example.igdb_api_based_android_app.model

data class GameResponse(
    val id: Long,
    val name: String,
    val summary: String?
    // Add more fields as needed, e.g., cover, genres, etc.
)