package com.example.miscellaneousapp.features.apps.ui

import androidx.lifecycle.ViewModel
import com.example.miscellaneousapp.navigation.AppNavigator
import com.example.miscellaneousapp.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(private val appNavigation: AppNavigator) : ViewModel() {
    fun onNavigateToInstagram() {
        appNavigation.tryNavigateTo(Destination.InstagramScreen())
    }

    fun onNavigateToTodoApp() {
        appNavigation.tryNavigateTo(Destination.TodoScreen())
    }
}