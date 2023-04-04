package com.example.miscellaneousapp.features.todo.domain

import com.example.miscellaneousapp.features.todo.data.TaskRepository
import com.example.miscellaneousapp.features.todo.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    operator fun invoke() : Flow<List<TaskModel>> = taskRepository.tasks
}