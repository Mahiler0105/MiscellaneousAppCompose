package com.example.miscellaneousapp.features.instagram.ui

import android.app.Activity
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.miscellaneousapp.R
import com.example.miscellaneousapp.features.instagram.ui.components.CustomTextField
import com.example.miscellaneousapp.features.instagram.ui.components.CustomTextFieldPassword
import com.example.miscellaneousapp.features.instagram.ui.components.Footer
import com.example.miscellaneousapp.features.instagram.ui.components.Header
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.compose.OnParticleSystemUpdateListener
import nl.dionsegijn.konfetti.core.PartySystem

@Composable
fun InstagramLoginScreen(instagramLoginViewModel: InstagramLoginViewModel = hiltViewModel()) {
    val activity = LocalContext.current as Activity
    val showConfetti by instagramLoginViewModel.showConfetti.observeAsState(initial = false)

    Box {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp)
        ) {
            Header(Modifier.align(Alignment.TopEnd)) { activity.finish() }
            InstagramLoginBody(Modifier.align(Alignment.Center), instagramLoginViewModel)
        }
        Footer(Modifier.align(Alignment.BottomCenter)) { instagramLoginViewModel.onSignUp() }
    }
    if (showConfetti) {
        KonfettiView(
            modifier = Modifier.fillMaxSize(),
            parties = ConfettiPresets.festive(),
            updateListener = object : OnParticleSystemUpdateListener {
                override fun onParticleSystemEnded(system: PartySystem, activeSystems: Int) {
                    if (activeSystems == 0) instagramLoginViewModel.endedConfetti()
                }
            }
        )
    }
}

@Composable
fun InstagramLoginBody(modifier: Modifier, loginViewModel: InstagramLoginViewModel) {
    val email by loginViewModel.username.observeAsState(initial = "")
    val password by loginViewModel.password.observeAsState(initial = "")
    val enabledLogin by loginViewModel.enabledLogin.observeAsState(initial = false)

    Column(modifier = modifier.padding(horizontal = 7.dp)) {
        Image(
            painter = painterResource(id = R.drawable.insta),
            contentDescription = "Instagram",
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )
        Spacer(modifier = Modifier.size(30.dp))
        CustomTextField(
            email,
            "Phone number, username or email",
            KeyboardType.Email
        ) {
            loginViewModel.onUsernameChange(it)
        }
        Spacer(modifier = Modifier.size(15.dp))
        CustomTextFieldPassword(password, "Password") {
            loginViewModel.onPasswordChange(it)
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
                ) { loginViewModel.onForgotPassword() })
        Spacer(modifier = Modifier.size(25.dp))
        Button(
            onClick = {
                loginViewModel.onLogin()
            }, enabled = enabledLogin, modifier = Modifier.fillMaxWidth(),
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
                    ) { loginViewModel.onContinueAs() })

        }
    }
}