package com.example.igdb_api_based_android_app.ui.reusableComponents.top.menuButton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MenuButton(
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit
) {
    var menuOpen by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { menuOpen = true }) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }
        AnimatedVisibility(visible = menuOpen) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { menuOpen = false }
            )
        }
        AnimatedVisibility(visible = menuOpen) {
            Column(
                Modifier
                    .width(220.dp)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text("Settings", Modifier.clickable {
                    menuOpen = false
                    onSettingsClick()
                })
                Spacer(Modifier.height(16.dp))
                Text("About", Modifier.clickable {
                    menuOpen = false
                    onAboutClick()
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuButtonPreview() {
    MenuButton(onSettingsClick = {}, onAboutClick = {})
}

@Preview(showBackground = true)
@Composable
fun MenuButtonPreviewWithOpen() {
    var menuOpen by remember { mutableStateOf(true) }
    Box {
        MenuButton(
            onSettingsClick = {},
            onAboutClick = {}
        )
        if (menuOpen) {
            Column(
                Modifier
                    .width(220.dp)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text("Settings", Modifier.clickable { menuOpen = false })
                Spacer(Modifier.height(16.dp))
                Text("About", Modifier.clickable { menuOpen = false })
            }
        }
    }
}