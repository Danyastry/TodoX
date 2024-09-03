package com.example.todos.di

import com.example.todos.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
    viewModel { MainViewModel(get()) }
}