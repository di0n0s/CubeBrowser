package com.example.sfcar.cubebrowser.views.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sfcar.cubebrowser.R
import com.example.sfcar.cubebrowser.extensions.inTransaction
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    private fun addFragment(savedInstanceState: Bundle?) =
            savedInstanceState
                    ?: supportFragmentManager.inTransaction { add(fragmentContainer.id, fragment()) }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
                fragmentContainer.id) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    abstract fun fragment(): BaseFragment

}
