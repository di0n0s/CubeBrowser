package com.example.domain.repository

import com.example.domain.model.Board
import io.reactivex.Observable

interface CubeRepository {

    fun getBoard(): Observable<Board>
}