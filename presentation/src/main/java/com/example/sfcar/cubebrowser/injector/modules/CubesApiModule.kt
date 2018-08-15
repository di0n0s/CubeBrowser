package com.example.sfcar.cubebrowser.injector.modules

import com.example.data.net.ApiConstants
import com.example.data.net.CubesApiService
import com.example.data.repository.CubeRepositoryImp
import com.example.data.repository.datasource.CubeDataStore
import com.example.data.repository.datasource.CubeDataStoreImp
import com.example.domain.executor.PostExecutionThread
import com.example.domain.repository.CubeRepository
import com.example.sfcar.cubebrowser.UIThread
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class CubesApiModule {

    @Provides
    @Singleton
    fun provideCubesApi(): CubesApiService {
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(ApiConstants.TIMEOUT_CONNECTION_VALUE, TimeUnit.SECONDS)
                .readTimeout(ApiConstants.TIMEOUT_READ_VALUE, TimeUnit.SECONDS)
                .writeTimeout(ApiConstants.TIMEOUT_WRITE_VALUE, TimeUnit.SECONDS)
        val builder = Retrofit.Builder()
                .baseUrl(ApiConstants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        return builder.client(httpClient.build()).build().create(CubesApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCubeRepository(cubeRepositoryImp: CubeRepositoryImp): CubeRepository = cubeRepositoryImp

    @Provides
    @Singleton
    fun provideCubeDataSore(cubeDataStoreImp: CubeDataStoreImp) : CubeDataStore = cubeDataStoreImp

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread
}