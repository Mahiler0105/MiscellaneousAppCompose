package com.example.miscellaneousapp.features.instagram.ui.components

import android.app.Activity
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Header(modifier: Modifier, onExitApp: () -> Unit) {
    IconButton(
        modifier = modifier.size(30.dp),
        onClick = { onExitApp() }
    ) {
        Icon(Icons.Default.Close, contentDescription = "Close App", Modifier.size(30.dp))
    }
}