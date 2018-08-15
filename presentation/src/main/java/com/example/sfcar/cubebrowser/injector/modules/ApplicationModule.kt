package com.example.sfcar.cubebrowser.injector.modules

import android.content.Context
import com.example.sfcar.cubebrowser.CubeBrowserApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: CubeBrowserApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Context = application
}