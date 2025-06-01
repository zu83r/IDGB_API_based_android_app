package com.example.igdb_api_based_android_app.ui.screens.gameScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.igdb_api_based_android_app.ui.reusableComponents.top.TopBar
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import com.example.igdb_api_based_android_app.model.Tag


@Composable
fun GameScreen(
    title: String,
    description: String,
    coverResId: Int,
    releaseDate: String,
    publisher: String,
    studios: String,
    genres: String,
    tags: List<Tag> = emptyList(), // <-- Add this
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBar(
            searchText = searchText,
            onSearchTextChange = { searchText = it },
            onMenuClick = { /* TODO */ },
            onUserClick = { /* TODO */ }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = coverResId),
                contentDescription = null,
                modifier = Modifier.size(120.dp) // Increased size
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                AutoScrollTitle(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(12.dp)) // More space between title and date
                Text(
                    text = releaseDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* TODO: Option 1 action */ }) {
                Text("Option 1")
            }
            Button(onClick = { /* TODO: Option 2 action */ }) {
                Text("Option 2")
            }
            // Add more options as needed
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .height(160.dp) // Set the max height as needed
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text("Publisher: $publisher", style = MaterialTheme.typography.bodySmall)
                Text("Studios: $studios", style = MaterialTheme.typography.bodySmall)
            }
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.weight(1f)
            ) {
                Text("Genres: $genres", style = MaterialTheme.typography.bodySmall)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
       if (tags.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                tags.forEach { tag ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        tag.iconRes?.let {
                            Image(
                                painter = painterResource(it),
                                contentDescription = tag.name,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        Text(tag.name, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

@Composable
fun AutoScrollTitle(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    scrollWidth: Int = 200 // px, adjust as needed
) {
    val offset = remember { androidx.compose.animation.core.Animatable(0f) }
    LaunchedEffect(text) {
        while (true) {
            offset.animateTo(
                targetValue = scrollWidth.toFloat(),
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 4000, delayMillis = 1000)
            )
            delay(1000)
            offset.snapTo(0f)
        }
    }
    Box(
        modifier = modifier
            .width(200.dp)
            .height(32.dp)
            .clipToBounds()
    ) {
        BasicText(
            text = text,
            style = style,
            modifier = Modifier.graphicsLayer {
                translationX = -offset.value
            }
        )
    }
}