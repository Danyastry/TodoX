package com.example.todos.di

import androidx.room.Room
import com.example.todos.data.local.TodoDao
import com.example.todos.data.local.TodoDatabase
import com.example.todos.data.repository.TodoRepositoryImpl
import com.example.todos.domain.repository.TodoRepository
import org.koin.dsl.module

val dataModule = module {

    single { Room.databaseBuilder(get(), TodoDatabase::class.java, "db1").build() }

    single<TodoDao> { get<TodoDatabase>().todoDao() }

    single<TodoRepository> { TodoRepositoryImpl(get()) }

}