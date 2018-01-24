package com.myfirst.note.noteeditor.ui

import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.myfirst.note.noteeditor.Android
import es.dmoral.toasty.Toasty

/**
 * Created by shichengxinag on 2017/9/18.
 */

abstract class BaseActivity : AppCompatActivity() {

    @get:LayoutRes
    abstract val layout: Int

    abstract fun init(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        ButterKnife.bind(this)
        init(savedInstanceState)
    }

    fun toast(msg: String) {
        Toasty.info(this, msg).show()
    }

    fun error(err: String) {
        Toasty.error(this, err).show()
    }

    fun startActivity(clz: Class<*>) {
        startActivity(Intent(this, clz))
    }

    fun displayLoading() {
        if (!isFinishing)
            Android.displayLoadingDialog(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Android.dismissLoading()
    }
}
