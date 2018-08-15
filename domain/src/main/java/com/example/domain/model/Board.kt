package com.example.domain.model

data class Board (val id: Int,
                  val name: String,
                  val description: String,
                  val cubeList: List<Cube>)