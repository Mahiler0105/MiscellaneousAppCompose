package com.example.miscellaneousapp.features.todo.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.miscellaneousapp.features.todo.ui.TasksViewModel
import com.example.miscellaneousapp.features.todo.ui.model.TaskModel

@Composable
fun TaskList(tasks: List<TaskModel>, tasksViewModel: TasksViewModel){
    if(tasks.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = "No tienes tareas creadas")
        }
    } else {
        LazyColumn{
            items(tasks,  key = { it.id }){
                TaskItem(it, tasksViewModel)
            }
        }
    }
}