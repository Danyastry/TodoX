package com.example.todos.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todos.data.model.TodoEntity

@Database(entities = [TodoEntity::class], version = 2)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

}