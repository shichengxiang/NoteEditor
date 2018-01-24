package com.myfirst.note.noteeditor

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater

/**
 * Created by shichengxinag on 2017/9/18.
 */

object Android {
    internal var mLoadingDialog: AlertDialog? = null

    fun displayLoadingDialog(context: Context) {
        if (mLoadingDialog == null) {
            mLoadingDialog = AlertDialog.Builder(context, R.style.Dialog_Trans).create()
            val view = LayoutInflater.from(context.applicationContext).inflate(R.layout.dialog_loading, null)
            mLoadingDialog!!.setView(view)
        }
        mLoadingDialog!!.show()
        val window = mLoadingDialog!!.window
        val attributes = window!!.attributes
        attributes.width = (60 * context.resources.displayMetrics.density).toInt()
        attributes.height = (60 * context.resources.displayMetrics.density).toInt()
        window.attributes = attributes
    }

    fun dismissLoading() {
        if (mLoadingDialog != null)
            mLoadingDialog!!.dismiss()
    }
}
