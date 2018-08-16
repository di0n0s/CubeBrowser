package com.example.sfcar.cubebrowser.presenters.cubeList

import com.example.domain.interactor.params.Params
import com.example.domain.interactor.usecase.CubeListUseCase
import com.example.domain.model.Board
import com.example.domain.model.Cube
import com.example.sfcar.cubebrowser.entities.BoardView
import com.example.sfcar.cubebrowser.entities.mappers.BoardViewMapper
import com.example.sfcar.cubebrowser.injector.PerFragment
import com.example.sfcar.cubebrowser.observers.base.CubeListObserver
import com.example.sfcar.cubebrowser.views.cubeList.CubeListView
import javax.inject.Inject

@PerFragment
class CubeListPresenterImp @Inject constructor(private val cubeListUseCase: CubeListUseCase) : CubeListPresenter {

    @Inject
    lateinit var view: CubeListView
    override var boardView: BoardView = BoardView()

    override fun start() {
        cubeListUseCase.execute(Params(), CubeListObserver(this))
    }

    override fun onBoardReceived(board: Board) {
        view.setNullAdapter()
        boardView = BoardViewMapper.toViewObject(board)
        view.setBoardView()
        showOrHideEmptyAndRecyclerView(board.cubeList)
        view.showProgressBar(false)
    }

    override fun onErrorReceived() {
        view.showEmptyView()
        view.hideRecyclerView()
        view.showProgressBar(false)
        view.showErrorMessage()
    }

    override fun onResume() {}

    override fun onPause() {}

    override fun onDestroy() {
        cubeListUseCase.dispose()
    }

    private fun showOrHideEmptyAndRecyclerView(cubeList : List<Cube>) {
        if (cubeList.isEmpty()) {
            view.showEmptyView()
            view.hideRecyclerView()
        } else {
            view.showRecyclerView()
            view.hideEmptyView()
        }
    }
}