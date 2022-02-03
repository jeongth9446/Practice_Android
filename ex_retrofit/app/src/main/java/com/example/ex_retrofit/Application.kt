package com.example.ex_retrofit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Provider

@HiltAndroidApp
class ApplicationController: Application(){
    companion object {
        lateinit var INSTANCE: ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}