package com.example.todos.data.repository

import com.example.todos.data.model.TodoEntity
import com.example.todos.domain.repository.TodoRepository
import com.example.todos.data.local.TodoDao
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(private val dao: TodoDao) : TodoRepository {

    override suspend fun addTodo(todoEntity: TodoEntity) {
        dao.addTodo(todoEntity)
    }


    override suspend fun deleteTodo(todoEntity: TodoEntity) {
        dao.deleteTodo(todoEntity)
    }


    override suspend fun updateTodo(todoEntity: TodoEntity) {
        dao.updateTodo(todoEntity)
    }


    override suspend fun getTodo(): Flow<List<TodoEntity>> {
        return dao.getTodos()
    }

}