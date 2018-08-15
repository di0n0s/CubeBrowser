package com.example.sfcar.cubebrowser.views.base

interface BaseListView {

    fun showProgressBar(show: Boolean)
    fun showRecyclerView()
    fun hideRecyclerView()
    fun hideEmptyView()
    fun showEmptyView()
    fun setItems()
    fun setNullAdapter()
    fun setRefreshingBehaviour()
    fun setEmptyView()
    fun showErrorMessage(message: String?)

}