package com.example.igdb_api_based_android_app.ui.reusableComponents.top.menuButton

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import androidx.compose.foundation.clickable

@Composable
fun MenuButton(
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit
) {
    var drawerOpen by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(
        if (drawerOpen) DrawerValue.Open else DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                ListItem(
                    headlineContent = { Text("Settings") },
                    modifier = androidx.compose.ui.Modifier
                        .clickable {
                            scope.launch { drawerState.close() }
                            onSettingsClick()
                        }
                )
                ListItem(
                    headlineContent = { Text("About") },
                    modifier = androidx.compose.ui.Modifier
                        .clickable {
                            scope.launch { drawerState.close() }
                            onAboutClick()
                        }
                )
            }
        }
    ) {
        IconButton(onClick = {
            drawerOpen = true
            scope.launch { drawerState.open() }
        }) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuButtonPreview() {
    MenuButton(onSettingsClick = {}, onAboutClick = {})
}