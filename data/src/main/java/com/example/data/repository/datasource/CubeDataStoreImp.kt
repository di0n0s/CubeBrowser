package com.example.data.repository.datasource

import com.example.data.net.CubesApiService
import javax.inject.Inject

class CubeDataStoreImp @Inject constructor(private val cubesApiService: CubesApiService) : CubeDataStore {
}