package com.example.miscellaneousapp.features.instagram.ui

import android.util.Log
import androidx.compose.ui.res.painterResource
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miscellaneousapp.R
import com.example.miscellaneousapp.features.instagram.ui.components.CustomTextField
import com.example.miscellaneousapp.features.instagram.ui.components.Footer
import com.example.miscellaneousapp.features.instagram.ui.components.Header
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.schedule

@Composable
fun InstagramLoginScreen() {
    Box {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp)
        ) {
            Header(Modifier.align(Alignment.TopEnd))
            InstagramLoginBody(Modifier.align(Alignment.Center))
        }
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun InstagramLoginBody(modifier: Modifier) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var enabledButton by rememberSaveable { mutableStateOf(false) }
    var showConfetti by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier.padding(horizontal = 7.dp)) {
        Image(
            painter = painterResource(id = R.drawable.insta),
            contentDescription = "Instagram",
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )
        Spacer(modifier = Modifier.size(30.dp))
        CustomTextField(username, "Phone number, username or email", false, KeyboardType.Email) {
            username = it
            enabledButton = enableInstagramButton(username, password)
        }
        Spacer(modifier = Modifier.size(15.dp))
        CustomTextField(password, "Password", true) {
            password = it
            enabledButton = enableInstagramButton(username, password)
        }
        Spacer(modifier = Modifier.size(15.dp))
        Text(text = "Forgot password?",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            modifier = Modifier
                .align(
                    Alignment.End
                )
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) { Log.i("Forgot", "Forgot Password") })
        Spacer(modifier = Modifier.size(25.dp))
        Button(
            onClick = {
                showConfetti = true
                username = ""
                password = ""
                enabledButton = false

                Timer().schedule(5000) {
                    showConfetti = false
                }
            }, enabled = enabledButton, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                disabledBackgroundColor = Color(0xFF78C8F9),
                backgroundColor = Color(0xFF4EA8E9),
                contentColor = Color.White,
                disabledContentColor = Color.White
            )
        ) {
            Text(text = "Log In")
        }
        Spacer(modifier = Modifier.size(20.dp))
        com.example.miscellaneousapp.features.instagram.ui.components.Divider("OR")
        Spacer(modifier = Modifier.size(40.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "Facebook",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "Continue as David Johnson",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4EA8E9),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { Log.i("Continua as", "Continue as message") })
        }
    }

    if (showConfetti) {
        KonfettiView(
            modifier = Modifier.fillMaxSize(),
            parties = listOf(
                Party(
                    position = Position.Relative(0.5, -0.1),
                    timeToLive = 5000,
                    emitter = Emitter(duration = 5, TimeUnit.SECONDS).perSecond(30)
                )
            ),
        )
    }
}

fun enableInstagramButton(email: String, password: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 5;
}