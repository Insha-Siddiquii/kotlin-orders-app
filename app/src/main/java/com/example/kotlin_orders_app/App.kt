package com.example.kotlin_orders_app

import android.app.Application
import com.example.kotlin_orders_app.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

//Class App will start Koin and init() the modules dependencies

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    remoteDataSourceModule,
                    repoModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}