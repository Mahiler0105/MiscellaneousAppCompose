package com.example.miscellaneousapp.features.todo.domain

import com.example.miscellaneousapp.features.todo.data.TaskRepository
import javax.inject.Inject

class DeleteAllTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(){
        taskRepository.deleteAll()
    }
}