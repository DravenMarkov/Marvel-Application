package com.example.marvelapplication.presentation

import android.app.Application
import com.example.marvelapplication.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    netModule,
                    repositoryModule,
                    useCase,
                    dataBase
                )
            )
        }
    }
}