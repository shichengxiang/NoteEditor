package com.myfirst.note.noteeditor.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.myfirst.note.noteeditor.R
import com.myfirst.note.noteeditor.fragment.HomeFragment
import com.myfirst.note.noteeditor.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

//    @BindView(R.id.navigation)
//    internal var mNavigationView: BottomNavigationView? = null
//    @BindView(R.id.viewPager)
//    internal var mViewPager: ViewPager? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                viewPager!!.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                viewPager!!.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override val layout: Int
        get() = R.layout.activity_main

    override fun init(savedInstanceState: Bundle?) {
        viewPager!!.adapter = MainPageAdapter(supportFragmentManager)
        navigation!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        viewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0)
                    navigation!!.selectedItemId = R.id.navigation_home
                else
                    navigation!!.selectedItemId = R.id.navigation_dashboard
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        displayLoading()
        toast("提交成功！")
    }

    inner class MainPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = HomeFragment()
                1 -> fragment = MineFragment()
            }
            return fragment
        }

        override fun getCount(): Int {
            return 2
        }
    }

}
