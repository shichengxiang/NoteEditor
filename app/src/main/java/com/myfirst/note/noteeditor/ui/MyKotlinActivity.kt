package com.myfirst.note.noteeditor.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.myfirst.note.noteeditor.R
import kotlinx.android.synthetic.main.activity_my_kotlin.*

class MyKotlinActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.text = "首页"
                message.setTextColor(ContextCompat.getColor(this, R.color.orange))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.text = "第二页"
                message.setTextColor(ContextCompat.getColor(this, R.color.red_ff725f))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    private val mOnNavigationItemReselectedListener = BottomNavigationView.OnNavigationItemReselectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

            }
            R.id.navigation_dashboard -> {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_kotlin)
        message.text = "这样可以么?"
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    message.text = "首页"
                    message.setTextColor(ContextCompat.getColor(this, R.color.orange))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    message.text = "第二页"
                    message.setTextColor(ContextCompat.getColor(this, R.color.red_ff725f))
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
        navigation.setOnNavigationItemReselectedListener { item -> item.setVisible(false) }

    }

    /**
     * 函数
     */
    fun method1(a: Int): String {
        if (a > 1)
            return "" + a
        else
            return "0"
    }

    fun sum(a: Int, b: Int) = print(a + b)

    /**
     * 条件表达式
     */
    fun max(a: Int, b: Int) = if (a < b) a else b

    fun max2(a: Int, b: Int): Int {
        if (a > b)
            return a
        else
            return b
    }

    /**
     * 判断null值 ，类型检测
     */
    fun getStringLength(args: Array<Any>): Int? {
        for (a in args.indices)
            print(args[a])
        print("dfafaffjf==${args[0]}")
        if (args[0] is String)
            return 1
        else
            return args.size

    }


}
