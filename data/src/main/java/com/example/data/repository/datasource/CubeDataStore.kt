package com.example.data.repository.datasource

import com.example.data.entities.BoardResponseDto
import io.reactivex.Observable

interface CubeDataStore {

    fun getBoard(): Observable<BoardResponseDto>
}