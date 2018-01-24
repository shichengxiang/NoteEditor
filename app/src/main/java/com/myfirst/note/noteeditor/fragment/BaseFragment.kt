package com.myfirst.note.noteeditor.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import butterknife.ButterKnife

/**
 * Created by shichengxinag on 2017/9/18.
 */

abstract class BaseFragment : Fragment() {

    abstract val layout: Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater!!.inflate(layout, container, false)
        ButterKnife.bind(this, inflate)
        return inflate
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    fun newInstance(position: Int): Fragment? {
        var fragment: Fragment? = null
        if (position == 0) {
            fragment = HomeFragment()
        } else if (position == 1) {
            fragment = MineFragment()
        }
        return fragment
    }
}
