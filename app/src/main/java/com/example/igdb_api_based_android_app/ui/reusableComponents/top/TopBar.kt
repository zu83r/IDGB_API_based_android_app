package com.example.igdb_api_based_android_app.ui.reusableComponents.top

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.igdb_api_based_android_app.ui.reusableComponents.top.menuButton.MenuButton


@Composable
fun TopBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onMenuClick: () -> Unit,
    onUserClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MenuButton(
            onSettingsClick = onMenuClick,
            onAboutClick = { /* TODO: handle About */ }
        )
        Spacer(modifier = Modifier.width(8.dp))
        TextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            placeholder = { Text("Search...") },
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            singleLine = true
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = onUserClick) {
            Icon(Icons.Default.Person, contentDescription = "User")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    var search by remember { mutableStateOf("") }
    TopBar(
        searchText = search,
        onSearchTextChange = { search = it },
        onMenuClick = {},
        onUserClick = {}
    )
}
