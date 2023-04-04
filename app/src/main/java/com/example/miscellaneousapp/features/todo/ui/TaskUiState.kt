package com.example.miscellaneousapp.features.todo.ui

import com.example.miscellaneousapp.features.todo.ui.model.TaskModel

sealed interface TaskUiState {
    object Loading: TaskUiState
    data class Error(val throwable: Throwable) : TaskUiState
    data class Success(val tasks: List<TaskModel>) : TaskUiState
}