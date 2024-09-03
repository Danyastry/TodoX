package com.example.todos

import android.app.Application
import com.example.todos.di.dataModule
import com.example.todos.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            AndroidLogger(Level.INFO)
            androidContext(this@App)
            modules(dataModule, domainModule)
        }
    }
}