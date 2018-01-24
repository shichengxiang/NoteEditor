package com.myfirst.note.noteeditor.fragment

import android.content.Intent
import android.view.View

import com.myfirst.note.noteeditor.R
import com.myfirst.note.noteeditor.ui.CalendarTransActivity

import butterknife.OnClick

/**
 * Created by shichengxinag on 2017/9/18.
 */

class HomeFragment : BaseFragment() {

    override val layout: Int
        get() = R.layout.fragment_home

    @OnClick(R.id.view_displayCalendar)
    fun onClickEvent(view: View) {
        when (view.id) {
            R.id.view_displayCalendar -> activity.startActivity(Intent(activity, CalendarTransActivity::class.java))
        }
    }

}
