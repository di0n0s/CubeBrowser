package com.example.sfcar.cubebrowser.injector.modules

import com.example.sfcar.cubebrowser.injector.PerFragment
import com.example.sfcar.cubebrowser.interfaces.CubeActivityListener
import com.example.sfcar.cubebrowser.views.cube.CubeActivity
import dagger.Module
import dagger.Provides

@Module
class CubeModule (private val cubeActivity: CubeActivity) {

    @Provides
    @PerFragment
    fun provideCubeListActivityListener(): CubeActivityListener = cubeActivity
}