package com.example.data.entities

data class BoardResponseDto(val id: Int?,
                            val name: String?,
                            val description: String?,
                            val items: List<CubeResponseDto>?)