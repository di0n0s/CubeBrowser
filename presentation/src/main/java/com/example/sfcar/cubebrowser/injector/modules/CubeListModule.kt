package com.example.sfcar.cubebrowser.injector.modules

import com.example.sfcar.cubebrowser.injector.PerFragment
import com.example.sfcar.cubebrowser.interfaces.CubeListActivityListener
import com.example.sfcar.cubebrowser.views.cubeList.CubeListActivity
import com.example.sfcar.cubebrowser.views.cubeList.CubeListFragment
import com.example.sfcar.cubebrowser.views.cubeList.CubeListView
import dagger.Module
import dagger.Provides

@Module
class CubeListModule(private val cubeListFragment: CubeListFragment,
                     private val cubeListActivity: CubeListActivity) {

    @Provides
    @PerFragment
    fun provideCubeListView(): CubeListView = cubeListFragment

    @Provides
    @PerFragment
    fun provideCubeListActivityListener() : CubeListActivityListener = cubeListActivity
}