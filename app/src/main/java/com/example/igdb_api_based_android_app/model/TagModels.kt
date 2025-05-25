package com.example.igdb_api_based_android_app.model

enum class TagType {
    AGE, VIOLENCE, SWEARING, SEXUAL_CONTENT, DRUGS, OTHER
}

data class Tag(
    val id: Int,
    val name: String,
    val type: TagType,
    val iconRes: Int? = null // Optional: for displaying icons
)

data class GameTagInfo(
    val gameId: Long,
    val tags: List<Tag>
)