package com.example.sfcar.cubebrowser.views.cubeList


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sfcar.cubebrowser.CubeBrowserApplication

import com.example.sfcar.cubebrowser.R
import com.example.sfcar.cubebrowser.injector.modules.BaseListModule
import com.example.sfcar.cubebrowser.injector.modules.CubeListModule
import com.example.sfcar.cubebrowser.views.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class CubeListFragment : BaseFragment(), CubeListView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutId(), container, false)
    }

    override fun layoutId(): Int = R.layout.fragment_cube_list

    override fun setupFragmentComponent() {
        CubeBrowserApplication
                .applicationComponent
                .plus(BaseListModule(this.context!!), CubeListModule(this, activity as CubeListActivity))
                .inject(this)
    }

    override fun showProgressBar(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRecyclerView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideRecyclerView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideEmptyView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setItems() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setNullAdapter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRefreshingBehaviour() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setEmptyView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorMessage(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
