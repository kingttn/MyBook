package com.haunp.mybookstore

import android.app.Application
import com.haunp.mybookstore.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.stopKoin

class MyApplication : Application() {
    override fun onCreate() {
        instance = this
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@MyApplication)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }
}