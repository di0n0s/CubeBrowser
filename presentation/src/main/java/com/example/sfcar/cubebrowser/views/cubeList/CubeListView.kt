package com.example.sfcar.cubebrowser.views.cubeList

import com.example.sfcar.cubebrowser.entities.BoardView
import com.example.sfcar.cubebrowser.views.base.BaseListView

interface CubeListView : BaseListView{

    fun setBoardView(boardView: BoardView)
}