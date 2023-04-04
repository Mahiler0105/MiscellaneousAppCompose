package com.example.miscellaneousapp.features.apps.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AppsScreen(
    isDarkTheme: Boolean,
    onChangeTheme: () -> Unit,
    appsViewModel: AppsViewModel = hiltViewModel(),
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)){
        Row() {
            Icon(Icons.Outlined.LightMode, contentDescription = "light_mode")
            Switch(checked = isDarkTheme, onCheckedChange = {
                onChangeTheme()
            })
            Icon(Icons.Outlined.DarkMode, contentDescription = "dark_mode")
        }

        Button(onClick = { appsViewModel.onNavigateToInstagram() }, Modifier.fillMaxWidth()) {
            Text(text = "IR A INSTAGRAM")
        }
        Button(onClick = { appsViewModel.onNavigateToTodoApp() }, Modifier.fillMaxWidth()) {
            Text(text = "IR A TODO APP")
        }
    }
}