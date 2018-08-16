package com.example.sfcar.cubebrowser.observers.base

import com.example.sfcar.cubebrowser.presenters.base.BaseApiPresenter
import io.reactivex.observers.DisposableObserver

abstract class BaseObserver<T>(private val presenter: BaseApiPresenter) : DisposableObserver<T>() {

    override fun onComplete() {
    }

    override fun onError(e: Throwable) {
        presenter.onErrorReceived()
    }
}