package com.example.sfcar.cubebrowser.entities.mappers

import com.example.domain.model.Board
import com.example.sfcar.cubebrowser.entities.BoardView
import com.example.sfcar.cubebrowser.entities.CubeView

object BoardViewMapper {

    fun toViewObject(board: Board): BoardView =
            BoardView(board.id!!, board.name, board.description, getCubeViewList(board))

    private fun getCubeViewList(board: Board): ArrayList<CubeView> {
        val cubeViewList = ArrayList<CubeView>()
        board.cubeList.forEach {
            cubeViewList.add(CubeViewMapper.toViewObject(it))
        }
        return cubeViewList
    }
}