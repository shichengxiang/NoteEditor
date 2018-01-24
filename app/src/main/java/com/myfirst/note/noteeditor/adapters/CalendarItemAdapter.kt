package com.myfirst.note.noteeditor.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.kelin.calendarlistview.library.BaseCalendarItemAdapter
import com.kelin.calendarlistview.library.BaseCalendarItemModel
import com.myfirst.note.noteeditor.R

/**
 * Created by kelin on 16-7-19.
 */
class CalendarItemAdapter(context: Context) : BaseCalendarItemAdapter<CustomCalendarItemModel>(context) {

    override fun getView(date: String?, model: CustomCalendarItemModel, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(mContext).inflate(R.layout.griditem_custom_calendar_item, null) as ViewGroup

        val dayNum = view.findViewById(R.id.tv_day_num) as TextView
        dayNum.text = model.dayNumber

        view.setBackgroundResource(com.kelin.calendarlistview.library.R.drawable.bg_shape_calendar_item_normal)

        if (model.isToday) {
            dayNum.setTextColor(mContext.resources.getColor(com.kelin.calendarlistview.library.R.color.red_ff725f))
            dayNum.text = mContext.resources.getString(com.kelin.calendarlistview.library.R.string.today)
        }

        if (model.isHoliday) {
            dayNum.setTextColor(mContext.resources.getColor(com.kelin.calendarlistview.library.R.color.red_ff725f))
        }


        if (model.status == BaseCalendarItemModel.Status.DISABLE) {
            dayNum.setTextColor(mContext.resources.getColor(android.R.color.darker_gray))
        }

        if (!model.isCurrentMonth) {
            dayNum.setTextColor(mContext.resources.getColor(com.kelin.calendarlistview.library.R.color.gray_bbbbbb))
            view.isClickable = true
        }

        val dayNewsCount = view.findViewById(R.id.tv_day_new_count) as TextView
        if (model.newsCount > 0) {
            dayNewsCount.text = String.format("%条", model.newsCount)
            dayNewsCount.visibility = View.VISIBLE
        } else {
            dayNewsCount.visibility = View.GONE
        }

        val isFavImageView = view.findViewById(R.id.image_is_fav) as ImageView
        if (model.isFav) {
            isFavImageView.visibility = View.VISIBLE
        } else {
            isFavImageView.visibility = View.GONE
        }


        return view
    }
}
