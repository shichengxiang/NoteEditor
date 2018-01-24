package com.myfirst.note.noteeditor.ui

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView

import com.myfirst.note.noteeditor.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

import butterknife.BindView

/**
 * Created by shichengxinag on 2017/11/10.
 */

class TestActivity : BaseActivity() {
    @BindView(R.id.tv_content)
    internal var mTextView: TextView? = null
    @BindView(R.id.rl_main)
    internal var mRelativeLayout: TextView? = null
    @BindView(R.id.iv_image)
    internal var mIv_image: ImageView? = null

    override val layout: Int
        get() = R.layout.activity_test

    internal var mTarget: Target = object : Target {
        override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
            mIv_image!!.setImageBitmap(bitmap)
        }

        override fun onBitmapFailed(errorDrawable: Drawable) {

        }

        override fun onPrepareLoad(placeHolderDrawable: Drawable) {

        }
    }

    override fun init(savedInstanceState: Bundle?) {
        val displayMetrics = resources.displayMetrics
        mTextView!!.text = "width=" + displayMetrics.widthPixels + "\nheight=" + displayMetrics.heightPixels +
                "\ndpi=" + displayMetrics.density + "\nxdpi=" + displayMetrics.xdpi + "\nydpi" + displayMetrics.ydpi
        //        mRelativeLayout.setTextSize(20 * 400/310);
        mRelativeLayout!!.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f)
        //        ViewGroup.LayoutParams layoutParams = mRelativeLayout.getLayoutParams();
        //        layoutParams.width = (int) (100 * displayMetrics.density);
        //        mRelativeLayout.setLayoutParams(layoutParams);
        //        Picasso.with(this).load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1168399963,3251010511&fm=27&gp=0.jpg")
        //                .resize((int) (100 * getResources().getDisplayMetrics().density), (int) (100 * getResources().getDisplayMetrics().density)).centerCrop().into(mIv_image);

        Picasso.with(this).load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1168399963,3251010511&fm=27&gp=0.jpg")
                .resize((100 * resources.displayMetrics.density).toInt(), (100 * resources.displayMetrics.density).toInt()).centerCrop().into(mTarget)
    }

}
