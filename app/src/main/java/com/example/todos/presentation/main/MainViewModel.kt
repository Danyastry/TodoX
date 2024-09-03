package com.example.todos.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todos.data.model.TodoEntity
import com.example.todos.domain.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val repository: TodoRepository) : ViewModel() {

    private val _todos: MutableStateFlow<List<TodoEntity>> = MutableStateFlow(emptyList())
    val todos = _todos.asStateFlow()

    private val _editTodo: MutableStateFlow<TodoEntity?> = MutableStateFlow(null)
    val editTodo = _editTodo.asStateFlow()

    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTodo().collect { data ->
                _todos.update { data }
            }
        }
    }

    fun addTodo(todoEntity: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTodo(todoEntity)
        }
    }

    fun updateTodo(todoEntity: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTodo(todoEntity)
        }
    }

    fun deleteTodo(todoEntity: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTodo(todoEntity)
        }
    }

    fun setEditTodo(todoEntity: TodoEntity) {
        _editTodo.value = todoEntity
    }

    fun saveEditTodo(title: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            editTodo.value?.let { todo ->
                val updatedTodo = todo.copy(title = title, description = description)
                repository.updateTodo(updatedTodo)
            }
            _editTodo.value = null
        }
    }
}
