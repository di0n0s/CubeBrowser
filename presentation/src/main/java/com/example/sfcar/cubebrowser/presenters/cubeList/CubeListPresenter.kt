package com.example.sfcar.cubebrowser.presenters.cubeList

import com.example.domain.model.Board
import com.example.sfcar.cubebrowser.entities.BoardView
import com.example.sfcar.cubebrowser.presenters.base.BaseApiPresenter

interface CubeListPresenter : BaseApiPresenter {

    fun onBoardReceived(board: Board)
    var boardView : BoardView
}