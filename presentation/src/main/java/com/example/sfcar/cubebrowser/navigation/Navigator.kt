package com.example.sfcar.cubebrowser.navigation

import android.content.Context
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.sfcar.cubebrowser.R
import com.example.sfcar.cubebrowser.entities.CubeView
import com.example.sfcar.cubebrowser.views.cube.CubeActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor() {

    fun toCube(context: Context, position: Int, cubeView: CubeView, view: View) {
        setCubePosition(cubeView, position)
        val intentToLaunch = CubeActivity.getCallingIntent(context, cubeView)
        context.startActivity(intentToLaunch, prepareOptionsToBundle(context, view))
    }

    private fun setCubePosition(cubeView: CubeView, position: Int) {
        cubeView.position = position
    }

    private fun prepareOptionsToBundle(context: Context?, view: android.view.View): Bundle? {
        val transitionName = context?.getString(R.string.web_view_transition)
        val options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(context as AppCompatActivity, view, transitionName!!)
        return options.toBundle()
    }
}