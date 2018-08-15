package com.example.sfcar.cubebrowser.observers.base

import com.example.domain.model.Board
import com.example.sfcar.cubebrowser.presenters.cubeList.CubeListPresenterImp

class CubeListObserver(private val presenter: CubeListPresenterImp) : BaseObserver<Board>(presenter) {

    override fun onNext(t: Board) {
        if (t.id != null)
            presenter.onBoardReceived(t)
        else
            presenter.onErrorReceived()
    }
}