package com.example.domain.model

data class Board (val id: Int? = null,
                  val name: String = "",
                  val description: String = "",
                  val cubeList: List<Cube> = ArrayList())