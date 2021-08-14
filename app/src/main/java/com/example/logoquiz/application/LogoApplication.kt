package com.example.logoquiz.application

import android.app.Application

class LogoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: LogoApplication
            private set
    }
}