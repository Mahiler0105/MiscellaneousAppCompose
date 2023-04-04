package com.example.miscellaneousapp.features.instagram.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InstagramLoginViewModel @Inject constructor() : ViewModel() {
    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _enabledLogin = MutableLiveData<Boolean>()
    val enabledLogin: LiveData<Boolean> = _enabledLogin

    private val _showConfetti = MutableLiveData<Boolean>()
    val showConfetti: LiveData<Boolean> = _showConfetti

    fun onSignUp() {
        Log.i(TODO, "Sign Up Message")
    }

    fun onForgotPassword() {
        Log.i(TODO, "Forgot Password")
    }

    fun onContinueAs() {
        Log.i(TODO, "Continue As")
    }

    fun onUsernameChange(username: String) {
        _username.value = username
        enableLoginButton()
    }

    fun onPasswordChange(password: String) {
        _password.value = password
        enableLoginButton()
    }

    fun onLogin() {
        _username.value = ""
        _password.value = ""
        _enabledLogin.value = false
        _showConfetti.value = true
    }

    fun endedConfetti() {
        _showConfetti.value = false
    }

    private fun enableLoginButton() {
        val isValidUsername = _username.value?.let {
            Patterns.EMAIL_ADDRESS.matcher(it).matches()
        }

        val isValidPassword = _password.value?.let {
            it.length >= 5
        }

        _enabledLogin.value = isValidUsername == true && isValidPassword == true;
    }
    
    companion object {
        const val TODO = "TO-DO"
    }

}