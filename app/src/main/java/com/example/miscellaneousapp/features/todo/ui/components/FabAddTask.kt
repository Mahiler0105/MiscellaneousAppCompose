package com.example.miscellaneousapp.features.todo.ui.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import com.example.miscellaneousapp.features.todo.ui.TasksViewModel

@Composable
fun FabAddTask(tasksViewModel: TasksViewModel) {
    FloatingActionButton(onClick = { tasksViewModel.onAddDialogOpen() }) {
        Icon(imageVector = Icons.Filled.Delete, contentDescription = "add_task")
    }
}
