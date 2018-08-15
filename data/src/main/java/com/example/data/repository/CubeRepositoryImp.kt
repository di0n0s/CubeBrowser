package com.example.data.repository

import com.example.data.entities.mapper.BoardResponseMapper
import com.example.data.repository.datasource.CubeDataStore
import com.example.domain.model.Board
import com.example.domain.repository.CubeRepository
import io.reactivex.Observable
import javax.inject.Inject

class CubeRepositoryImp @Inject constructor(private val cubeDataStore: CubeDataStore) : CubeRepository {

    override fun getBoard(): Observable<Board> = cubeDataStore.getBoard().map { BoardResponseMapper.toBusinessObject(it) }
}