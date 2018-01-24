package com.myfirst.note.noteeditor

/**
 * Created by shichengxinag on 2017/12/1.
 */

object Util {
    fun concatStr(vararg strings: String): String {
        val result = StringBuffer("")
        if (strings != null && strings.size > 0) {
            for (str in strings) {
                result.append(str)
            }
        }
        return result.toString()
    }
}
