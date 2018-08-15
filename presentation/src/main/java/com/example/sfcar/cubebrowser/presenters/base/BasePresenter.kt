package com.example.sfcar.cubebrowser.presenters.base

interface BasePresenter {

    fun start()
    fun onResume()
    fun onPause()
    fun onDestroy()
}