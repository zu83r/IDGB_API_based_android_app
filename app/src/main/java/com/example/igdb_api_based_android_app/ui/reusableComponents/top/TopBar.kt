package com.example.igdb_api_based_android_app.ui.reusableComponents.top


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.igdb_api_based_android_app.ui.reusableComponents.top.menuButton.MenuButton
import com.example.igdb_api_based_android_app.ui.reusableComponents.top.profileButton.ProfileButton

@Composable
fun TopBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    /*onMenuSettingsClick: () -> Unit,
    onMenuAboutClick: () -> Unit,
    onProfileClick: () -> Unit,
    onLogoutClick: () -> Unit,*/
    modifier: Modifier = Modifier
) {
    var profileMenuOpen by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        /*MenuButton(
            onSettingsClick = onMenuSettingsClick,
            onAboutClick = onMenuAboutClick
        )
        Spacer(modifier = Modifier.width(8.dp))*/
        TextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            placeholder = { Text("Search...") },
            modifier = Modifier
                .weight(1f)
                .height(50.dp),
            singleLine = true
        )
        /*Spacer(modifier = Modifier.width(8.dp))
        ProfileButton(
            onProfileClick = onProfileClick,
            onLogoutClick = onLogoutClick,
            menuOpen = profileMenuOpen,
            onMenuOpenChange = { profileMenuOpen = it }
        )*/
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    var search by remember { mutableStateOf("") }
    TopBar(
        searchText = search,
        onSearchTextChange = { search = it },
        /*onMenuSettingsClick = {},
        onMenuAboutClick = {},
        onProfileClick = {},
        onLogoutClick = {}*/
    )
}
