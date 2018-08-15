package com.example.data.net

import com.example.data.entities.BoardResponseDto
import io.reactivex.Observable
import retrofit2.http.GET

interface CubesApiService {

    @GET("5b72fc9a32000073193a7f53")
    fun getBoard() :Observable<BoardResponseDto>
}