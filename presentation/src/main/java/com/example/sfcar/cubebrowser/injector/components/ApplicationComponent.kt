package com.example.sfcar.cubebrowser.injector.components

import com.example.sfcar.cubebrowser.injector.modules.*
import com.example.sfcar.cubebrowser.views.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, CubesApiModule::class])
interface ApplicationComponent {

    fun inject(baseActivity: BaseActivity)

    fun plus(baseListModule: BaseListModule, cubeListModule: CubeListModule): CubeListComponent

    fun plus(cubeModule: CubeModule) : CubeComponent


}