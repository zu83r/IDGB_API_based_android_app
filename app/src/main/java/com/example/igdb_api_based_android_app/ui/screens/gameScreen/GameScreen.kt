package com.example.igdb_api_based_android_app.ui.screens.gameScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.igdb_api_based_android_app.model.Tag
import com.example.igdb_api_based_android_app.ui.reusableComponents.top.TopBar
import kotlinx.coroutines.delay
import kotlin.text.compareTo
import kotlin.text.toFloat
import kotlin.unaryMinus

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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                tags.forEach { tag ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(tag.type.iconRes),
                            contentDescription = stringResource(tag.type.stringRes),
                            modifier = Modifier.size(60.dp)
                        )
                        Box(
                            modifier = Modifier.width(60.dp), // Match image width
                            contentAlignment = Alignment.Center
                        ) {
                            AutoScrollTag(
                                text = stringResource(tag.type.stringRes),
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp) // Adjust height as needed
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // TODO: Add gallery of images and videos here
            }
            // Scroll selection bar placeholder
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // TODO: Add scroll selection bar items here
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // TODO: Add composables for other games in the series here
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // TODO: Add composables for related links (e.g., official site, IGDB, Wikipedia, etc.)
        }


    }
}

@Composable
fun AutoScroll(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    scrollWidth: Dp
) {
    val density = LocalDensity.current
    var textWidthPx by remember(text) { mutableFloatStateOf(0f) }
    val offset = remember { androidx.compose.animation.core.Animatable(0f) }
    val scrollWidthPx = with(density) { scrollWidth.toPx() }

    LaunchedEffect(text, textWidthPx, scrollWidthPx) {
        offset.snapTo(0f)
        if (textWidthPx > scrollWidthPx) {
            while (true) {
                offset.animateTo(
                    targetValue = textWidthPx - scrollWidthPx,
                    animationSpec = androidx.compose.animation.core.tween(durationMillis = 4000, delayMillis = 1000)
                )
                delay(1000)
                offset.snapTo(0f)
            }
        }
    }

    Box(
        modifier = modifier
            .width(scrollWidth)
            .clipToBounds()
    ) {
        BasicText(
            text = text,
            style = style,
            onTextLayout = { textLayoutResult ->
                textWidthPx = textLayoutResult.size.width.toFloat()
            },
            modifier = Modifier
                .width(scrollWidth) // Always set width to scrollWidth
                .graphicsLayer {
                    translationX = if (textWidthPx > scrollWidthPx) -offset.value else 0f
                }
        )
    }
}

@Composable
fun AutoScrollTitle(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier
) {
    AutoScroll(
        text = text,
        style = style,
        modifier = modifier.height(32.dp),
        scrollWidth = 200.dp
    )
}

@Composable
fun AutoScrollTag(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier
) {
    AutoScroll(
        text = text,
        style = style,
        modifier = modifier.height(24.dp),
        scrollWidth = 60.dp
    )
}

