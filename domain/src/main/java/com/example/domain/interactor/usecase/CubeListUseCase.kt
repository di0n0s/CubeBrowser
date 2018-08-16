package com.example.domain.interactor.usecase

import com.example.domain.executor.PostExecutionThread
import com.example.domain.interactor.params.Params
import com.example.domain.model.Board
import com.example.domain.repository.CubeRepository
import io.reactivex.Observable
import javax.inject.Inject

class CubeListUseCase @Inject constructor(private val cubeRepository: CubeRepository,
                                          postExecutionThread: PostExecutionThread)
    : BaseUseCase<Board>(postExecutionThread = postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<Board> = cubeRepository.getBoard()

}