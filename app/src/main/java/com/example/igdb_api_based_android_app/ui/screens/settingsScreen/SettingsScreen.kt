package com.example.igdb_api_based_android_app.ui.screens.settingsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun SettingsScreen() {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            val annotatedString = buildAnnotatedString {
                append("Icons by ")
                pushStringAnnotation(tag = "Icons8", annotation = "https://icons8.com")
                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("Icons8")
                }
                pop()
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                ClickableText(
                    text = annotatedString,
                    style = MaterialTheme.typography.bodySmall,
                    onClick = { offset ->
                        annotatedString.getStringAnnotations(start = offset, end = offset)
                            .firstOrNull()?.let { annotation ->
                                uriHandler.openUri(annotation.item)
                            }
                    }
                )
            }
        }
    }
}