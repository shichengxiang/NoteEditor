package com.myfirst.note.noteeditor.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.kelin.calendarlistview.library.BaseCalendarListAdapter
import com.kelin.calendarlistview.library.CalendarHelper
import com.myfirst.note.noteeditor.R
import com.myfirst.note.noteeditor.entities.GetBeans.GetHome
import com.myfirst.note.noteeditor.ui.CalendarTransActivity

import java.util.Calendar

class DayNewsListAdapter(context: Context) : BaseCalendarListAdapter<GetHome>(context) {

    override fun getSectionHeaderView(date: String?, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val headerViewHolder: HeaderViewHolder
        val modelList = dateDataMap[date]
        if (convertView != null) {
            headerViewHolder = convertView.tag as HeaderViewHolder
        } else {
            convertView = inflater.inflate(R.layout.item_lvhead_calendar, null)
            headerViewHolder = HeaderViewHolder()
            headerViewHolder.dayText = convertView!!.findViewById(R.id.header_day) as TextView
            headerViewHolder.yearMonthText = convertView.findViewById(R.id.header_year_month) as TextView
            headerViewHolder.isFavImage = convertView.findViewById(R.id.header_btn_fav) as ImageView
            convertView.tag = headerViewHolder
        }

        val calendar = CalendarHelper.getCalendarByYearMonthDay(date)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        var dayStr = calendar.get(Calendar.DAY_OF_MONTH).toString()
        if (day < 10) {
            dayStr = "0" + dayStr
        }
        headerViewHolder.dayText!!.text = dayStr
        headerViewHolder.yearMonthText!!.text = CalendarTransActivity.YEAR_MONTH_FORMAT.format(calendar.time)
        return convertView
    }

    override fun getItemView(model: GetHome, date: String, pos: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val contentViewHolder: ContentViewHolder
        if (convertView != null) {
            contentViewHolder = convertView.tag as ContentViewHolder
        } else {
            convertView = inflater.inflate(R.layout.listitem_calendar_content, null)
            contentViewHolder = ContentViewHolder()
            contentViewHolder.titleTextView = convertView!!.findViewById(R.id.title) as TextView
            contentViewHolder.timeTextView = convertView.findViewById(R.id.time) as TextView
            contentViewHolder.newsImageView = convertView.findViewById(R.id.image) as ImageView
            convertView.tag = contentViewHolder
        }

        contentViewHolder.titleTextView!!.text = "内容提要！"
        contentViewHolder.timeTextView!!.text = date
        //        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(convertView.getResources())
        //                .setRoundingParams(RoundingParams.asCircle())
        //                .build();
        //        contentViewHolder.newsImageView.setHierarchy(hierarchy);
        //        contentViewHolder.newsImageView.setImageURI(Uri.parse(model.getImages().get(0)));
        //        Picasso.with(convertView.getContext()).load(Uri.parse(model.getImages().get(0)))
        //                .into(contentViewHolder.newsImageView);
        return convertView
    }

    private class HeaderViewHolder {
        internal var dayText: TextView? = null
        internal var yearMonthText: TextView? = null
        internal var isFavImage: ImageView? = null
    }

    private class ContentViewHolder {
        internal var titleTextView: TextView? = null
        internal var timeTextView: TextView? = null
        internal var newsImageView: ImageView? = null
    }

}
