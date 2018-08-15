package com.example.sfcar.cubebrowser.injector.components

import com.example.sfcar.cubebrowser.injector.PerFragment
import com.example.sfcar.cubebrowser.injector.modules.BaseListModule
import com.example.sfcar.cubebrowser.injector.modules.CubeListModule
import com.example.sfcar.cubebrowser.views.cubeList.CubeListFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [BaseListModule::class, CubeListModule::class])
interface CubeListComponent {

    fun inject(cubeListFragment: CubeListFragment)
}