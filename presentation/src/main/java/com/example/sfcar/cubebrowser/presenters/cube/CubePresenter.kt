package com.example.sfcar.cubebrowser.presenters.cube

import com.example.sfcar.cubebrowser.entities.CubeView
import com.example.sfcar.cubebrowser.presenters.base.BasePresenter

interface CubePresenter : BasePresenter {

    fun initCubeView(cubeView: CubeView)
    var cubeView : CubeView
}