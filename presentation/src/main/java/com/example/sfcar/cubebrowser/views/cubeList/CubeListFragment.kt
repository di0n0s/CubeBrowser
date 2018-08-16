package com.example.sfcar.cubebrowser.views.cubeList


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.example.sfcar.cubebrowser.CubeBrowserApplication
import com.example.sfcar.cubebrowser.R
import com.example.sfcar.cubebrowser.adapters.CubeListAdapter
import com.example.sfcar.cubebrowser.entities.CubeView
import com.example.sfcar.cubebrowser.entities.enumerations.EmptyViewEnum
import com.example.sfcar.cubebrowser.injector.modules.BaseListModule
import com.example.sfcar.cubebrowser.injector.modules.CubeListModule
import com.example.sfcar.cubebrowser.interfaces.AdapterListOnClickListener
import com.example.sfcar.cubebrowser.interfaces.CubeListActivityListener
import com.example.sfcar.cubebrowser.presenters.cubeList.CubeListPresenterImp
import com.example.sfcar.cubebrowser.views.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cube_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class CubeListFragment : BaseFragment(), CubeListView, AdapterListOnClickListener.ViewListener {

    @Inject
    lateinit var presenter: CubeListPresenterImp
    @Inject
    lateinit var layoutManager: GridLayoutManager
    @Inject
    lateinit var activityListener: CubeListActivityListener

    companion object {
        const val TAG = "CubeListFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayoutManager()
        setEmptyView()
        setRefreshingBehaviour()
        presenter.start()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cubeListRecyclerView.adapter = null
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun layoutId(): Int = R.layout.fragment_cube_list

    override fun setupFragmentComponent() {
        CubeBrowserApplication
                .applicationComponent
                .plus(BaseListModule(this.context!!), CubeListModule(this, activity as CubeListActivity))
                .inject(this)
    }

    override fun showProgressBar(show: Boolean) {
        if (swipeRefreshLayout.isRefreshing) {
            if (!show)
                swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun showRecyclerView() {
        cubeListRecyclerView.visibility = View.VISIBLE
    }

    override fun hideRecyclerView() {
        cubeListRecyclerView.visibility = View.GONE
    }

    override fun hideEmptyView() {
        emptyView.visibility = View.GONE
    }

    override fun showEmptyView() {
        emptyView.visibility = View.VISIBLE
    }

    override fun setNullAdapter() {
        cubeListRecyclerView.adapter = null
    }

    override fun setRefreshingBehaviour() {
        swipeRefreshLayout.setOnRefreshListener {
            presenter.start()
        }
    }

    override fun setEmptyView() = emptyView.fillViews(EmptyViewEnum.EMPTY_CUBE_LIST)


    override fun setBoardView() {
        setToolbarTitle(presenter.boardView.name)
        initAdapter(presenter.boardView.cubeList)
        notifyDataSetChanged()
    }

    override fun showErrorMessage() {
        showToastMessage(getString(R.string.error_network_connection))
    }

    override fun onItemSelected(position: Int, view: View) {
        presenter.boardView.cubeList[position].title = (view as WebView).title
        activityListener.goToCubeActivity(position, presenter.boardView.cubeList[position], view)
    }

    private fun setLayoutManager() {
        cubeListRecyclerView.layoutManager = layoutManager
    }

    private fun setToolbarTitle(title: String) {
        activityListener.setToolbarTitle(title)
    }

    private fun initAdapter(cubeViewList: ArrayList<CubeView>) {
        if (cubeListRecyclerView.adapter == null)
            cubeListRecyclerView.adapter = CubeListAdapter(cubeViewList, this)
    }

    private fun notifyDataSetChanged() {
        cubeListRecyclerView.adapter.notifyDataSetChanged()
    }

}
