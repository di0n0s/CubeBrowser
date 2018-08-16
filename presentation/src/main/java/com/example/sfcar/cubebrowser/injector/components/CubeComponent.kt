package com.example.sfcar.cubebrowser.injector.components

import com.example.sfcar.cubebrowser.injector.PerFragment
import com.example.sfcar.cubebrowser.injector.modules.CubeModule
import com.example.sfcar.cubebrowser.views.cube.CubeFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [CubeModule::class])
interface CubeComponent {

    fun inject(cubeFragment: CubeFragment)
}