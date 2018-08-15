package com.example.domain.model

data class Board (private val id: Int,
                  private val name: String,
                  private val description: String,
                  private val cubeList: List<Cube>)