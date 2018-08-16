package com.example.sfcar.cubebrowser.interfaces

import android.view.View
import com.example.sfcar.cubebrowser.entities.CubeView

interface CubeListActivityListener {

    fun setToolbarTitle(title: String)
    fun goToCubeActivity(position: Int, cubeView: CubeView, view: View)
}