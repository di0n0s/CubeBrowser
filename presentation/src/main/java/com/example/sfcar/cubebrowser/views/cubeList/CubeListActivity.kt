package com.example.sfcar.cubebrowser.views.cubeList

import android.view.View
import com.example.sfcar.cubebrowser.entities.CubeView
import com.example.sfcar.cubebrowser.interfaces.CubeListActivityListener
import com.example.sfcar.cubebrowser.views.base.BaseActivity
import com.example.sfcar.cubebrowser.views.base.BaseFragment
import kotlinx.android.synthetic.main.activity_base.*

class CubeListActivity : BaseActivity(), CubeListActivityListener {

    override fun createFragmentAndSettingTAG() {
        currentFragment = CubeListFragment()
        currentTag = CubeListFragment.TAG
    }

    override fun setToolbarTitle(title: String) {
        toolbar.title = title
    }

    override fun goToCubeActivity(position: Int, cubeView: CubeView, view: View) {
        navigator.toCube(this, position,cubeView, view)
    }

}
