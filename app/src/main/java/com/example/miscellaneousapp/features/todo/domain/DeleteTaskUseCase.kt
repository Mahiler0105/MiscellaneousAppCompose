package com.example.miscellaneousapp.features.todo.domain

import com.example.miscellaneousapp.features.todo.data.TaskRepository
import com.example.miscellaneousapp.features.todo.ui.model.TaskModel
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: TaskModel){
        taskRepository.delete(task)
    }
}