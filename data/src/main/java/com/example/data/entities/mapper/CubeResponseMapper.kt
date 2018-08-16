package com.example.data.entities.mapper

import com.example.data.entities.CubeResponseDto
import com.example.domain.model.Cube

object CubeResponseMapper {

    fun toBusinessObject(cubeResponseDto: CubeResponseDto): Cube =
            Cube(cubeResponseDto.id!!, cubeResponseDto.url!!)
}