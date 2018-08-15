package com.example.sfcar.cubebrowser.interfaces

import android.view.View

interface CubeListActivityListener {

    fun setToolbarTitle(title: String)
    fun goToCubeActivity(url: String, view: View)
}