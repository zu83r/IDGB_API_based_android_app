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
            )
        )
    }
}