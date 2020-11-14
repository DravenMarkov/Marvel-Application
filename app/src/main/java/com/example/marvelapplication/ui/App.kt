package com.example.marvelapplication.ui

import android.app.Application
import com.example.marvelapplication.di.appModule
import com.example.marvelapplication.di.netModule
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
                    netModule
                )
            )
        }
    }
}