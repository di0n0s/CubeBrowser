package com.example.data.entities.mapper

import com.example.data.entities.BoardResponseDto
import com.example.data.entities.CubeResponseDto
import com.example.domain.model.Board
import com.example.domain.model.Cube

object BoardResponseMapper {

    fun toBusinessObject(boardResponseDto: BoardResponseDto?): Board? {
        if (boardResponseDto != null) {
            if (boardResponseDto.id != null && boardResponseDto.items != null) {
                return Board(boardResponseDto.id,
                        boardResponseDto.name ?: "Unknown Board Name",
                        boardResponseDto.description ?: "Unknown Board Description",
                        getCubeList(boardResponseDto.items))
            }
        }
        return null
    }

    private fun getCubeList(items: List<CubeResponseDto>): ArrayList<Cube> {
        val cubeList = ArrayList<Cube>()
        items.forEach {
            if (it.id != null && it.url != null && it.url.isNotBlank())
                cubeList.add(CubeResponseMapper.toBusinessObject(it))
        }
        return cubeList
    }
}