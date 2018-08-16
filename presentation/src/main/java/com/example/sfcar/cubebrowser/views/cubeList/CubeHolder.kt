package com.example.sfcar.cubebrowser.views.cubeList

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
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
        itemView.webView.setOnTouchListener { _, _ ->
            adapterListener.onItemSelected(adapterPosition, itemView)
            false
        }
    }

    private fun setUrl(cubeView: CubeView) {
        itemView.webView.loadUrl(cubeView.url)
        itemView.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                itemView.progressBar.visibility = View.GONE
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setJSEnabled() {
        itemView.webView.settings.javaScriptEnabled = true
    }
}