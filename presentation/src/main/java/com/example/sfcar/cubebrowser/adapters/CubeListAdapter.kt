package com.example.sfcar.cubebrowser.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sfcar.cubebrowser.R
import com.example.sfcar.cubebrowser.entities.CubeView
import com.example.sfcar.cubebrowser.interfaces.AdapterListOnClickListener
import com.example.sfcar.cubebrowser.views.cubeList.CubeHolder

class CubeListAdapter(private val cubeViewList: ArrayList<CubeView>, private val viewListener: AdapterListOnClickListener.ViewListener)
    : RecyclerView.Adapter<CubeHolder>(), AdapterListOnClickListener.AdapterListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CubeHolder =
            CubeHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_cube, parent, false), this)

    override fun getItemCount(): Int = cubeViewList.size

    override fun onBindViewHolder(holder: CubeHolder, position: Int) = holder.bindCube(cubeViewList[position])

    override fun onItemSelected(position: Int, view: View) {
        viewListener.onItemSelected(position, view)
    }
}