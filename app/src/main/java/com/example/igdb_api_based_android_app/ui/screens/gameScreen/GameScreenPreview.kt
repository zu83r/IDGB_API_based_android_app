package com.example.igdb_api_based_android_app.ui.screens.gameScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.igdb_api_based_android_app.R
import com.example.igdb_api_based_android_app.ui.theme.IGDB_API_based_android_appTheme

import com.example.igdb_api_based_android_app.model.PegiRatingsTags

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    IGDB_API_based_android_appTheme {
        GameScreenContent(
            title = "The Ancient Ruins of Eldoria",
            description = "This is a sample game description.",
            coverResId = R.drawable.ic_launcher_foreground,
            releaseDate = "2024-01-01",
            publisher = "Sample Publisher",
            studios = "Sample Studio",
            genres = "Action, Adventure",
            pegiTags = listOf(
                PegiRatingsTags.PEGI_3,
                PegiRatingsTags.PEGI_7,
                PegiRatingsTags.PEGI_FEAR,
                PegiRatingsTags.PEGI_IN_GAME_PURCHASES,
                PegiRatingsTags.PEGI_ONLINE,
                PegiRatingsTags.PEGI_VIOLENCE,
            )
        )
    }
}