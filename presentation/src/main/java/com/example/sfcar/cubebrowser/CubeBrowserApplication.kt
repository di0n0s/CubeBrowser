package com.example.sfcar.cubebrowser

import android.app.Application

class CubeBrowserApplication : Application() {

    companion object {
        lateinit var instance : CubeBrowserApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}