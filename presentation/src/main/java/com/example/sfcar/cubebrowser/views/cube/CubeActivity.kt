package com.example.sfcar.cubebrowser.views.cube

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.view.MenuItem
import com.example.sfcar.cubebrowser.R
import com.example.sfcar.cubebrowser.entities.CubeView
import com.example.sfcar.cubebrowser.interfaces.CubeActivityListener
import com.example.sfcar.cubebrowser.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_base.*

class CubeActivity : BaseActivity(), CubeActivityListener {

    companion object {
        private const val EXTRA_CUBE = "ExtraCube"

        fun getCallingIntent(context: Context, cubeView: CubeView): Intent {
            val callingIntent = Intent(context, CubeActivity::class.java)
            callingIntent.putExtra(EXTRA_CUBE, cubeView)
            return callingIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityTransitions()
        initSupportActionBar()
    }

    override fun createFragmentAndSettingTAG() {
        currentFragment = CubeFragment.newInstance(getCubeExtra())
        currentTag = CubeFragment.TAG
    }

    private fun getCubeExtra(): CubeView = intent.getParcelableExtra(EXTRA_CUBE)


    override fun setToolbarTitle(title: String) {
        toolbar.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val transition = Slide()
            transition.excludeTarget(android.R.id.statusBarBackground, true)
            window.enterTransition = transition
            window.returnTransition = transition
        }
    }

    private fun initSupportActionBar() {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
    }
}
