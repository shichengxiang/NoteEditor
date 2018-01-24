package com.myfirst.note.noteeditor.ui

//import com.myfirst.note.noteeditor.databinding.ActivityTestBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.myfirst.note.noteeditor.R
import com.myfirst.note.noteeditor.entities.GetBeans.Result

/**
 * Created by shichengxinag on 2017/11/29.
 */

class TestActivity2 : AppCompatActivity() {
    internal var result = Result()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
//        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test)
//        mBinding!!.userName = "我是字符串"
//        result.code = 1001
//        result.msg = "内部错误"
//        mBinding!!.user = result
//        //        mBinding.orderType.setText("使用id设值");
//        mBinding!!.orderType.setOnClickListener { Toasty.info(this@TestActivity2, result.msg).show() }
        initView()
    }

    private fun initView() {
//        mBinding!!.etUsername.setText("施城祥")

    }

    override fun onDestroy() {
        super.onDestroy()
//        mBinding!!.unbind()
    }
}
