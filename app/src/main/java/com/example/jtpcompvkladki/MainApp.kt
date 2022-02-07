package com.example.jtpcompvkladki

import android.app.Application
import android.util.Log
import com.example.jtpcompvkladki.di.networkModule
import com.example.jtpcompvkladki.di.repositoryModule
import com.example.jtpcompvkladki.di.viewModelModule
import com.example.jtpcompvkladki.model.PhotoRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

private const val TAG = "@@@ MainApp"

class MainApp :Application() {
    override fun onCreate() {
        Log.d(TAG, "onCreate() called")
        super.onCreate()
        startKoin {
            androidContext(this@MainApp)
            modules(listOf(viewModelModule, repositoryModule, networkModule))
        }
    }
}