package com.example.miscellaneousapp.features.todo.data

import com.example.miscellaneousapp.features.todo.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    val tasks: Flow<List<TaskModel>> =
        taskDao.getTasks().map {
            it.map { taskEntity ->
                TaskModel(id = taskEntity.id, name = taskEntity.name, selected = taskEntity.selected)
            }
    }
    suspend fun add(task: TaskModel){
        taskDao.addTask(task.toEntity())
    }

    suspend fun update(task: TaskModel){
        taskDao.updateTask(task.toEntity())
    }

    suspend fun delete(task: TaskModel){
        taskDao.deleteTask(task.toEntity())
    }

    suspend fun deleteAll(){
        taskDao.deleteAllTasks()
    }
}

fun TaskModel.toEntity() : TaskEntity {
    return TaskEntity(id = this.id, name = this.name, selected = this.selected)
}