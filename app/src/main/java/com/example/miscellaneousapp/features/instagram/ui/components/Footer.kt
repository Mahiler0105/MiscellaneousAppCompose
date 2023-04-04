package com.example.miscellaneousapp.features.instagram.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Footer(modifier: Modifier, onSignUp: () -> Unit) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Divider()
        Row(Modifier.padding(vertical = 20.dp)) {
            Text(text = "Don't have a account?", color = Color(0xFFB5B5B5), fontSize = 12.sp)
            Text(text = "Sign Up.", fontWeight = FontWeight.Bold, fontSize = 12.sp,
                color = Color(0xFF4EA8E9), modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { onSignUp() })
        }
    }
}