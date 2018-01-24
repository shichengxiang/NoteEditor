package com.myfirst.note.noteeditor.adapters

import com.kelin.calendarlistview.library.BaseCalendarItemModel

/**
 * Created by kelin on 16-7-20.
 */
class CustomCalendarItemModel : BaseCalendarItemModel() {
    var newsCount: Int = 0
    var isFav: Boolean = false
}
