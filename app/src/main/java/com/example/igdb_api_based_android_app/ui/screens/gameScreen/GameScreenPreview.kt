package com.example.igdb_api_based_android_app.ui.screens.gameScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.igdb_api_based_android_app.R
import com.example.igdb_api_based_android_app.ui.theme.IGDB_API_based_android_appTheme
import com.example.igdb_api_based_android_app.model.Tag
import com.example.igdb_api_based_android_app.model.TagType

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    IGDB_API_based_android_appTheme {
        GameScreen(
            title = "Sample Game ve000ry long title that should be truncated",
            description = "This is a sample game description.",
            coverResId = R.drawable.ic_launcher_foreground,
            releaseDate = "2024-06-01",
            publisher = "Sample Publisher",
            studios = "Studio A, Studio B",
            genres = "Action, Adventure",
            tags = listOf(
                Tag(id = 1, type = TagType.PEGI_18),
                Tag(id = 2, type = TagType.PEGI_ONLINE)
            )
        )
    }
}