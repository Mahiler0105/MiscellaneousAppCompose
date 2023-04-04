package com.example.miscellaneousapp.features.todo.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.miscellaneousapp.features.todo.ui.components.*

@Composable
fun TasksScreen(tasksViewModel: TasksViewModel = hiltViewModel()) {
    val showDialog: Boolean by tasksViewModel.showAddDialog.observeAsState(initial = false)
    val showDeleteDialog: Boolean by tasksViewModel.showDeleteDialog.observeAsState(initial = false)

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val context = LocalContext.current

    val uiState by produceState<TaskUiState>(
        initialValue = TaskUiState.Loading,
        key1 = lifecycle,
        key2 = tasksViewModel)
        {
            lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED){
                tasksViewModel.uiState.collect{ value = it }
            }
        }

    when(uiState){
        is TaskUiState.Error -> {
            Toast.makeText(context, "Ocurrió un error", Toast.LENGTH_LONG).show()
        }
        TaskUiState.Loading -> {
            CircularProgressIndicator()
        }
        is TaskUiState.Success -> {
            Column(Modifier.fillMaxSize()) {
                Scaffold(
                    topBar = { TopAppBar(title = { Text(text = "App Todo")}, actions = {
                         if((uiState as TaskUiState.Success).tasks.isNotEmpty()){
                             Row() {
                                 Icon(imageVector = Icons.Default.Delete, contentDescription = "delete_all",
                                     modifier = Modifier.clickable {
                                         tasksViewModel.onDeleteAllTask()
                                     })
                             }
                         }
                    })},
                    floatingActionButton = { FabAddTask(tasksViewModel) }
                ){
                    Box(modifier = Modifier.padding(it))
                    TaskList((uiState as TaskUiState.Success).tasks, tasksViewModel)
                    NewTaskDialog(
                        showDialog,
                        onDismiss = { tasksViewModel.onAddDialogClose() },
                        onTaskAdded = { newTask -> tasksViewModel.onTaskAdded(newTask) })
                    DeleteTaskDialog(
                        showDeleteDialog,
                        onDismiss = { tasksViewModel.onDeleteADialogClose() },
                        onDeleted = { tasksViewModel.onDeletedTask() }
                    )
                }
            }
        }
    }
}