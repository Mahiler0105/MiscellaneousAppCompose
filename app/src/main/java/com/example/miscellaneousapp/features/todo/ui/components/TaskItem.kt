package com.example.miscellaneousapp.features.todo.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.example.miscellaneousapp.features.todo.ui.TasksViewModel
import com.example.miscellaneousapp.features.todo.ui.model.TaskModel

@Composable
fun TaskItem(taskModel: TaskModel, tasksViewModel: TasksViewModel){
    Card(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        tasksViewModel.onPressTask(taskModel)
                    }
                )
            }, elevation = 3.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = taskModel.name)
            Checkbox(checked = taskModel.selected, onCheckedChange = { tasksViewModel.onSelectedTask(taskModel) })
        }
    }
}