package com.example.sfcar.cubebrowser

import android.app.Application
import com.example.sfcar.cubebrowser.injector.components.ApplicationComponent
import com.example.sfcar.cubebrowser.injector.components.DaggerApplicationComponent
import com.example.sfcar.cubebrowser.injector.modules.ApplicationModule

class CubeBrowserApplication : Application() {

    companion object {
        lateinit var instance: CubeBrowserApplication
        @JvmStatic
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initializeInjector()
    }

    private fun initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }}