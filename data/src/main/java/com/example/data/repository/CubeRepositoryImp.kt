package com.example.data.repository

import com.example.data.repository.datasource.CubeDataStore
import com.example.domain.repository.CubeRepository
import javax.inject.Inject

class CubeRepositoryImp @Inject constructor(private val cubeDataStore: CubeDataStore) : CubeRepository {
}