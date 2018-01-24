package com.myfirst.note.noteeditor.ui

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.webkit.JavascriptInterface

import com.myfirst.note.noteeditor.R
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient

import butterknife.BindView

/**
 * Created by shichengxinag on 2017/9/27.
 */

class X5WebViewActivity : BaseActivity() {

    @BindView(R.id.webView)
    internal var mWebView: WebView? = null
    private val fileUrl = "https://www.vcaihang.com/activityfile/2017/09/hetong2.pdf"
    private val pdfHtml = "file:///android_asset/pdf.html"

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val javaScript = "javascript: getpdf2('$fileUrl')"
            mWebView!!.loadUrl(javaScript)
        }
    }
    override val layout: Int
        get() = R.layout.activity_webview

    override fun init(savedInstanceState: Bundle?) {
        //https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506491991634&di=5154cbcf8d16dd19872c063af4012a9b&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ff2deb48f8c5494ee4280e3d824f5e0fe98257e55.jpg
        //        String url = "http://docs.google.com/gview?embedded=true&url=" + "https://www.vcaihang.com/activityfile/2017/09/hetong2.pdf";
        val url = "https://view.officeapps.live.com/op/view.aspx?src=" + "https://www.vcaihang.com/activityfile/2017/09/hetong2.pdf"
        //        String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506491991634&di=5154cbcf8d16dd19872c063af4012a9b&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ff2deb48f8c5494ee4280e3d824f5e0fe98257e55.jpg";
        val settings = mWebView!!.settings
        settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        settings.loadsImagesAutomatically = true
        settings.loadWithOverviewMode = true
        settings.javaScriptEnabled = true
        settings.useWideViewPort = true
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.domStorageEnabled = true
        mWebView!!.addJavascriptInterface(JsObject(this, fileUrl), "client")
        mWebView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view!!.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
                super.onPageStarted(view, url, favicon)
                //                pro.setVisibility(View.VISIBLE);
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                handler.sendEmptyMessage(2)
            }

        }
        mWebView!!.loadUrl(pdfHtml)
    }

    internal inner class JsObject(var mActivity: Activity, var url: String) {

        //    测试方法
        @JavascriptInterface
        fun dismissProgress(): String {
            return this.url
        }
    }
}
