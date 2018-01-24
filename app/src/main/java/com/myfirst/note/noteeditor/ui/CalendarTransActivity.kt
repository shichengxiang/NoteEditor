package com.myfirst.note.noteeditor.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.myfirst.note.noteeditor.R
import com.necer.ncalendar.calendar.NCalendar
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by shichengxinag on 2017/9/19.
 */

class CalendarTransActivity : BaseActivity() {
    @BindView(R.id.nCalendar)
    internal var mNCalendar: NCalendar? = null
    @BindView(R.id.recyclerView)
    internal var mRecyclerView: RecyclerView? = null
    internal var mCustomeAdapter: CustomeAdapter?=null

    override val layout: Int
        get() = R.layout.activity_calendartrans

    override fun init(savedInstanceState: Bundle?) {
        mNCalendar!!.toMonth()
        mNCalendar!!.setOnCalendarChangedListener { dateTime -> toast(YEAR_MONTH_FORMAT.format(dateTime.toDate())) }
        mCustomeAdapter = CustomeAdapter()
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        mRecyclerView!!.adapter = mCustomeAdapter
        mCustomeAdapter!!.setData(Arrays.asList("", "", "", "", ""))
    }

    internal inner class CustomeAdapter : RecyclerView.Adapter<CustomeAdapter.ViewHolder>() {

        var mData: MutableList<String> = ArrayList()

        fun setData(list: MutableList<String>?) {
            if (list == null || list.size < 1)
                mData.clear()
            else
                mData = list
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(applicationContext).inflate(R.layout.listitem_calendar_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        }

        override fun getItemCount(): Int {
            return mData.size
        }

        internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            init {
                ButterKnife.bind(this, itemView)
            }
        }
    }

    companion object {

        var YEAR_MONTH_FORMAT = SimpleDateFormat("yyyy-MM-dd")
    }
}
