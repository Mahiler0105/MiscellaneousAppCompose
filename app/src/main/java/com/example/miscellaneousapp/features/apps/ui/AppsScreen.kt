package com.example.miscellaneousapp.features.apps.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AppsScreen(
    isDarkTheme: Boolean,
    onChangeTheme: () -> Unit,
    appsViewModel: AppsViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    Icons.Outlined.LightMode,
                    contentDescription = "light_mode",
                    tint = if (!isDarkTheme) MaterialTheme.colors.onBackground else MaterialTheme.colors.background
                )
                Switch(checked = isDarkTheme, onCheckedChange = {
                    onChangeTheme()
                })
                Icon(
                    Icons.Outlined.DarkMode, contentDescription = "dark_mode",
                    tint = if (isDarkTheme) MaterialTheme.colors.onBackground else MaterialTheme.colors.background
                )
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        Button(onClick = { appsViewModel.onNavigateToInstagram() }, Modifier.fillMaxWidth()) {
            Text(text = "IR A INSTAGRAM")
        }
        Button(onClick = { appsViewModel.onNavigateToTodoApp() }, Modifier.fillMaxWidth()) {
            Text(text = "IR A TODO APP")
        }
    }
}