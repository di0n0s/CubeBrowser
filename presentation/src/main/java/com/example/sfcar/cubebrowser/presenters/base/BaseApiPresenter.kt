package com.example.sfcar.cubebrowser.presenters.base

interface BaseApiPresenter : BasePresenter {

    fun showLoading()
    fun hideLoading()
    fun onErrorReceived(errorCode: Int)
}