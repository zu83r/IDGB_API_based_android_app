package com.example.igdb_api_based_android_app.model

enum class TagType {
    PEGI
}

data class Tag(
    val id: Int,
    val name: String,
    val type: TagType,
    val iconRes: Int? = null
)