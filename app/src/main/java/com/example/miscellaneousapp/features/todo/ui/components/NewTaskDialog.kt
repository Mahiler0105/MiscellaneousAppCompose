package com.example.miscellaneousapp.features.todo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun NewTaskDialog(show: Boolean, onDismiss: () -> Unit, onTaskAdded: (String) -> Unit){
    var newTask by rememberSaveable { mutableStateOf("") }
    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Surface(
                shape = RoundedCornerShape(size = 10.dp)
            ) {
                Column(Modifier.padding(horizontal = 15.dp, vertical = 15.dp)) {
                    Text(text = "Añade una tarea", Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.size(10.dp))
                    TextField(value = newTask, onValueChange = { newTask = it }, Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.size(20.dp))
                    Button(onClick = { onTaskAdded(newTask); newTask = "" }, Modifier.fillMaxWidth(), enabled = newTask.isNotEmpty()) {
                        Text(text = "Añadir")
                    }
                }
            }
        }
    }
}