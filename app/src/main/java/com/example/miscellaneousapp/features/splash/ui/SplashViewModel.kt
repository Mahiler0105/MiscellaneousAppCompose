package com.example.miscellaneousapp.features.splash.ui

import androidx.lifecycle.ViewModel
import com.example.miscellaneousapp.navigation.AppNavigator
import com.example.miscellaneousapp.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val appNavigator: AppNavigator) : ViewModel() {
    fun onNavigateMainScreen() {
        appNavigator.popStack()
        appNavigator.tryNavigateTo(Destination.MainScreen())
    }
}