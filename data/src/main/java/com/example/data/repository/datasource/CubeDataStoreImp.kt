package com.example.data.repository.datasource

import com.example.data.entities.BoardResponseDto
import com.example.data.net.CubesApiService
import io.reactivex.Observable
import javax.inject.Inject

class CubeDataStoreImp @Inject constructor(private val cubesApiService: CubesApiService) : CubeDataStore {

    override fun getBoard(): Observable<BoardResponseDto> = cubesApiService.getBoard()
}