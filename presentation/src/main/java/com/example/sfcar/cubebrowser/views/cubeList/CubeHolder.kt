package com.example.sfcar.cubebrowser.views.cubeList

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.sfcar.cubebrowser.entities.CubeView
import com.example.sfcar.cubebrowser.interfaces.AdapterListOnClickListener
import kotlinx.android.synthetic.main.list_item_cube.view.*

class CubeHolder(itemView: View, private val adapterListener: AdapterListOnClickListener.AdapterListener) : RecyclerView.ViewHolder(itemView) {

    fun bindCube(cubeView: CubeView) {
        setUrl(cubeView)
        setJSEnabled()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        itemView.setOnClickListener { adapterListener.onItemSelected(adapterPosition, itemView) }
    }

    private fun setUrl(cubeView: CubeView) {
        itemView.webView.loadUrl(cubeView.url)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setJSEnabled() {
        itemView.webView.settings.javaScriptEnabled = true
    }
}