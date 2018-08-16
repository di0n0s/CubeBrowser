package com.example.sfcar.cubebrowser.views.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sfcar.cubebrowser.CubeBrowserApplication
import com.example.sfcar.cubebrowser.R
import com.example.sfcar.cubebrowser.extensions.inTransaction
import com.example.sfcar.cubebrowser.navigation.Navigator
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    protected lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setupActivityComponent()
        addFragment(savedInstanceState)
    }

    private fun addFragment(savedInstanceState: Bundle?) =
            savedInstanceState
                    ?: supportFragmentManager.inTransaction { replace(fragmentContainer.id, fragment()) }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
                fragmentContainer.id) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun setupActivityComponent() {
        CubeBrowserApplication
                .applicationComponent
                .inject(this)
    }

    abstract fun fragment(): BaseFragment

}
