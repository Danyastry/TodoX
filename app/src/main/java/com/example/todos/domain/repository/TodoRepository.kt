package com.example.todos.domain.repository

import com.example.todos.data.model.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun addTodo(todoEntity: TodoEntity)

    suspend fun deleteTodo(todoEntity: TodoEntity)

    suspend fun updateTodo(todoEntity: TodoEntity)

    suspend fun getTodo(): Flow<List<TodoEntity>>

}