package com.example.sfcar.cubebrowser.views.cube


import android.annotation.SuppressLint
import android.app.Fragment
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.sfcar.cubebrowser.CubeBrowserApplication
import com.example.sfcar.cubebrowser.R
import com.example.sfcar.cubebrowser.entities.CubeView
import com.example.sfcar.cubebrowser.injector.modules.CubeModule
import com.example.sfcar.cubebrowser.interfaces.CubeActivityListener
import com.example.sfcar.cubebrowser.presenters.cube.CubePresenterImpl
import com.example.sfcar.cubebrowser.views.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cube.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class CubeFragment : BaseFragment() {

    @Inject
    lateinit var presenter: CubePresenterImpl
    @Inject
    lateinit var activityListener: CubeActivityListener

    companion object {
        const val TAG = "CubeFragment"
        private const val ARG_CUBE = "ARG_CUBE"

        fun newInstance(cubeView: CubeView): CubeFragment {
            val fragment = CubeFragment()
            val args = Bundle()
            args.putParcelable(ARG_CUBE, cubeView)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initCubeView(arguments?.getParcelable(ARG_CUBE)!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWebView()
        activityListener.setToolbarTitle(presenter.cubeView.title)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun layoutId(): Int = R.layout.fragment_cube

    override fun setupFragmentComponent() {
        CubeBrowserApplication
                .applicationComponent
                .plus(CubeModule(context as CubeActivity))
                .inject(this)
    }

    private fun setWebView() {
        webView.loadUrl(presenter.cubeView.url)
        setJSEnabled()
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                if (view?.title?.isNotBlank()!!)
                    activityListener.setToolbarTitle(view.title!!)
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setJSEnabled() {
        webView.settings.javaScriptEnabled = true
    }
}
