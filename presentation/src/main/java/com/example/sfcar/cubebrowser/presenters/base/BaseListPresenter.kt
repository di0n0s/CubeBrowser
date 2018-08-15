package com.example.sfcar.cubebrowser.presenters.base

interface BaseListPresenter<T> : BaseApiPresenter {
    var model: ArrayList<T>
}