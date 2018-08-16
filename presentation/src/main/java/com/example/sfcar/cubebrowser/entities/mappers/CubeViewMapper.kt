package com.example.sfcar.cubebrowser.entities.mappers

import com.example.domain.model.Cube
import com.example.sfcar.cubebrowser.entities.CubeView

object CubeViewMapper {

    fun toViewObject(cube: Cube): CubeView =
            CubeView(id = cube.id, url = cube.url)
}