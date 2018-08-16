package com.example.sfcar.cubebrowser.presenters.cube

import com.example.sfcar.cubebrowser.entities.CubeView
import com.example.sfcar.cubebrowser.injector.PerFragment
import javax.inject.Inject

@PerFragment
class CubePresenterImpl @Inject constructor() : CubePresenter {

    override var cubeView: CubeView = CubeView()

    override fun initCubeView(cubeView: CubeView) {
        this.cubeView = cubeView
    }

    override fun start() {}

    override fun onResume() {}

    override fun onPause() {}

    override fun onDestroy() {}
}