package com.example.miscellaneousapp.features.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1)
abstract class TodoDataBase : RoomDatabase() {
    abstract fun TaskDao(): TaskDao
}