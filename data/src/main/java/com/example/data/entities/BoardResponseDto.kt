package com.example.data.entities

data class BoardResponseDto(private val id: Int?,
                            private val name: String?,
                            private val description: String?,
                            private val items: List<CubeResponseDto>?)