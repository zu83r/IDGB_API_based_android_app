package com.example.igdb_api_based_android_app.ui.screens.gameScreen

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.igdb_api_based_android_app.R
import com.example.igdb_api_based_android_app.model.GameResponse
import com.example.igdb_api_based_android_app.model.PegiRatingsTags
import com.example.igdb_api_based_android_app.ui.reusableComponents.top.TopBar
import com.example.igdb_api_based_android_app.viewmodel.GameViewModel
import kotlinx.coroutines.delay
import kotlin.compareTo
import androidx.compose.animation.core.tween
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import kotlin.compareTo
import kotlin.text.compareTo

@Composable
fun GameScreen(viewModel: GameViewModel) {
    val games by viewModel.games.observeAsState(emptyList<GameResponse>())
    LaunchedEffect(Unit) { viewModel.loadGames() }

    games.firstOrNull()?.let { game: GameResponse ->
        GameScreenContent(
            title = game.name,
            description = game.summary ?: "",
            coverResId = R.drawable.ic_launcher_foreground,
            releaseDate = "Unknown",
            publisher = "Unknown",
            studios = "Unknown",
            genres = "Unknown",
            pegiTags = emptyList() // Use List<PegiRatingsTags>
        )
    }
}

@Composable
fun GameScreenContent(
    title: String,
    description: String,
    coverResId: Int,
    releaseDate: String,
    publisher: String,
    studios: String,
    genres: String,
    pegiTags: List<PegiRatingsTags>

)  {
    var searchText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TopBar(
            searchText = searchText,
            onSearchTextChange = { searchText = it }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = coverResId),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                AutoScrollTitle(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(12.dp))
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
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .height(160.dp)
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
        if (pegiTags.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                pegiTags.forEach { tag ->
                    Column(
                        modifier = Modifier.width(60.dp), // Ensures both icon and text are in a 60.dp column
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(tag.iconRes),
                            contentDescription = stringResource(tag.stringRes),
                            modifier = Modifier.size(60.dp)
                        )
                        AutoScrollTag(
                            text = stringResource(tag.stringRes),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.fillMaxWidth(),
                            centerText = true // Center if not scrolling
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // TODO: Add gallery of images and videos here
            }
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
fun AutoScrollText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    scrollWidth: Dp,
    centerText: Boolean = false
) {
    val scrollState = rememberScrollState()
    var textWidth by remember { mutableStateOf(0) }
    val shouldScroll = textWidth > with(LocalDensity.current) { scrollWidth.toPx() }

    Box(
        modifier = modifier
            .width(scrollWidth)
            .height(32.dp)
            .clipToBounds(),
        contentAlignment = Alignment.Center // Always center vertically
    ) {
        BasicText(
            text = text,
            style = style,
            modifier = Modifier
                .horizontalScroll(scrollState)
                .onGloballyPositioned { coordinates ->
                    textWidth = coordinates.size.width
                }
        )
    }

    if (shouldScroll) {
        LaunchedEffect(text) {
            scrollState.scrollTo(0)
            delay(1000)
            val maxScroll = scrollState.maxValue
            if (maxScroll > 0) {
                while (true) {
                    scrollState.animateScrollTo(
                        maxScroll,
                        animationSpec = tween(durationMillis = 4000)
                    )
                    delay(1000)
                    scrollState.scrollTo(0)
                    delay(1000)
                }
            }
        }
    }
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun AutoScrollTitle(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier.height(32.dp)
    ) {
        val width = maxWidth
        AutoScrollText(
            text = text,
            style = style,
            modifier = Modifier.height(32.dp),
            scrollWidth = width
        )
    }
}

@Composable
fun AutoScrollTag(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    centerText: Boolean = false
) {
    val tagWidth = 60.dp
    Box(
        modifier = modifier
            .width(tagWidth)
            .height(24.dp),
        contentAlignment = Alignment.Center
    ) {
        AutoScrollText(
            text = text,
            style = style,
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp),
            scrollWidth = tagWidth,
            centerText = centerText
        )
    }
}