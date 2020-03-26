package com.learning.animation.activities

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.learning.animation.R
import kotlinx.android.synthetic.main.activity_drawer2.*

class DrawerActivity2 : AppCompatActivity() {

    private var isFirst = true
    private val durationTime = 300L
    private var screenSize : Int = 1232

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer2)
    }

    fun clicked(v: View) {
        if(screenSize == 1232){
            screenSize = parentLayout.measuredWidth
        }
        if (isFirst) {
            heightReducer(viewRel)
            widthReducer(viewRel)
            marginIncreaser(viewRel)
            widthIncrease(nav_view, true)
            addHead(nav_view)
            addView(nav_view)
        } else {
            heightIncrease(viewRel)
            widthIncrease(viewRel)
            marginReducer(viewRel)
            widthReducer(nav_view, true)
            nav_view.animate()
                .alpha(0.0F)
                .withEndAction {
                    nav_view.alpha = 1F
                    nav_view.removeAllViews()
                }
                .duration = durationTime
        }
        isFirst = !isFirst
    }

    private fun heightReducer(view: View) {
        val height = view.measuredHeight
        val anim = ValueAnimator.ofInt(height, (height * 0.8).toInt())
        anim.addUpdateListener {
            val params = view.layoutParams
            params.height = it.animatedValue as Int
            view.layoutParams = params
        }
        anim.duration = durationTime
        anim.start()
    }

    private fun widthReducer(view: View, setWidth: Boolean = false) {
        val width = view.measuredWidth
        val anim = ValueAnimator.ofInt(
            if (setWidth) (screenSize * 0.6).toInt() else width,
            if (setWidth) 0 else (width * 0.8).toInt()
        )
        anim.addUpdateListener {
            val params = view.layoutParams
            params.width = it.animatedValue as Int
            view.layoutParams = params
        }
        anim.duration = durationTime
        anim.start()
    }

    private fun marginIncreaser(view: View) {
        val anim = ValueAnimator.ofInt(0, (parentLayout.measuredWidth))
        anim.addUpdateListener {
            val params = view.layoutParams as ViewGroup.MarginLayoutParams
            params.marginStart = it.animatedValue as Int
            view.layoutParams = params
        }
        anim.duration = durationTime
        anim.start()
    }

    private fun heightIncrease(view: View) {
        val height = view.measuredHeight
        val anim = ValueAnimator.ofInt(height, (height / 0.8).toInt())
        anim.addUpdateListener {
            val params = view.layoutParams
            params.height = it.animatedValue as Int
            view.layoutParams = params
        }
        anim.duration = durationTime
        anim.start()
    }

    private fun widthIncrease(view: View, setWidth: Boolean = false) {
        val width = view.measuredWidth
        val anim = ValueAnimator.ofInt(width, if (setWidth) (screenSize * 0.6).toInt() else (width / 0.8).toInt())
        anim.addUpdateListener {
            val params = view.layoutParams
            params.width = it.animatedValue as Int
            view.layoutParams = params
        }
        anim.duration = durationTime
        anim.start()
    }

    private fun marginReducer(view: View) {
        val anim = ValueAnimator.ofInt((parentLayout.measuredWidth), 0)
        anim.addUpdateListener {
            val params = view.layoutParams as ViewGroup.MarginLayoutParams
            params.marginStart = it.animatedValue as Int
            view.layoutParams = params
        }
        anim.duration = durationTime
        anim.start()
    }

    private fun addView(rootLayout: LinearLayout) {
        val iconArray: Array<Int> = arrayOf(
            R.drawable.ic_feed,
            R.drawable.ic_explore,
            R.drawable.ic_activity,
            R.drawable.ic_find_friends,
            R.drawable.ic_settings,
            R.drawable.ic_logout
        )
        val nameArr = arrayOf(
            R.string.feed,
            R.string.explore,
            R.string.activity,
            R.string.findFriends,
            R.string.settings,
            R.string.logout
        )
        iconArray.forEach {
            val view = LayoutInflater.from(this).inflate(R.layout.pair_view, null)
            view.findViewById<TextView>(R.id.textView).text =
                resources.getString(nameArr[iconArray.indexOf(it)])
            val icon = view.findViewById<ImageView>(R.id.icon)
            icon.setImageResource(it)
            rootLayout.addView(view)
            val anim = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
            anim.duration = ((iconArray.indexOf(it) + 1) * 50) + 300L
            icon.startAnimation(anim)

        }


    }

    private fun addHead(rootView: LinearLayout) {
        val view = LayoutInflater.from(this).inflate(R.layout.header_layout, null)
        rootView.addView(view)
        val anim = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        anim.duration = durationTime
        view.findViewById<ImageView>(R.id.image).startAnimation(anim)
    }

}
