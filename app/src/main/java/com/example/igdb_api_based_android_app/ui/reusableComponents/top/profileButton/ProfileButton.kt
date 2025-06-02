package com.example.igdb_api_based_android_app.ui.reusableComponents.top.profileButton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.igdb_api_based_android_app.ui.reusableComponents.top.menuButton.MenuButton

@Composable
fun ProfileButton(
    onProfileClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    var profileOpen by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { profileOpen = true }) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }
        AnimatedVisibility(visible = profileOpen) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { profileOpen = false }
            )
        }
        AnimatedVisibility(visible = profileOpen) {
            Column(
                Modifier
                    .width(220.dp)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text("Profile", Modifier.clickable {
                    profileOpen = false
                    onProfileClick()
                })
                Spacer(Modifier.height(16.dp))
                Text("Logout", Modifier.clickable {
                    profileOpen = false
                    onLogoutClick()
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileButtonPreview() {
    ProfileButton(onProfileClick = {}, onLogoutClick = {})
}

@Preview(showBackground = true)
@Composable
fun ProfileButtonPreviewWithOpen() {
    var menuOpen by remember { mutableStateOf(true) }
    Box {
        ProfileButton(
            onProfileClick = {},
            onLogoutClick = {}
        )
        if (menuOpen) {
            Column(
                Modifier
                    .width(220.dp)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text("Profile", Modifier.clickable { menuOpen = false })
                Spacer(Modifier.height(16.dp))
                Text("Logout", Modifier.clickable { menuOpen = false })
            }
        }
    }
}