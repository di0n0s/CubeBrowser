package com.example.sfcar.cubebrowser.injector.modules

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import com.example.sfcar.cubebrowser.injector.PerFragment
import dagger.Module
import dagger.Provides

@Module
class BaseListModule(private val context: Context) {

    @Provides
    @PerFragment
    fun provideGridLayoutManager(): GridLayoutManager = GridLayoutManager(context, 2)

}