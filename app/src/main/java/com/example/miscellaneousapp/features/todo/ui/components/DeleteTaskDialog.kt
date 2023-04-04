package com.example.miscellaneousapp.features.todo.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DeleteTaskDialog(show: Boolean, onDismiss: () -> Unit, onDeleted: () -> Unit){
    if(show){
        AlertDialog(
            title = {
                Text(text = "Seguro que desea eliminar la tarea")
            },
            onDismissRequest = { onDismiss() },
            confirmButton = {
                Button(onClick = { onDeleted() }) {
                    Text(text = "Eliminar tarea")
                }
            },
            dismissButton = {
                Button(onClick = { onDismiss() }) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}