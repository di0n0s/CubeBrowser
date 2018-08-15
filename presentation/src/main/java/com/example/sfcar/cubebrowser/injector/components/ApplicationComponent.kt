package com.example.sfcar.cubebrowser.injector.components

import com.example.sfcar.cubebrowser.injector.modules.ApplicationModule
import com.example.sfcar.cubebrowser.injector.modules.CubesApiModule
import com.example.sfcar.cubebrowser.views.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, CubesApiModule::class])
interface ApplicationComponent {

    fun inject(baseActivity: BaseActivity)

}