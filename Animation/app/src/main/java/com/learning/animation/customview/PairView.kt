package com.learning.animation.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewPropertyAnimator
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.learning.animation.R
import kotlinx.android.synthetic.main.pair_view.view.*

class PairView(context: Context, attrs : AttributeSet) : RelativeLayout(context, attrs) {

    init {
        inflate(context, R.layout.pair_view, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.PairView)

        val textView : TextView = this.findViewById(R.id.textView)
        val icon : ImageView = this.findViewById(R.id.icon)

        textView.text = attributes.getText(R.styleable.PairView_text)
        icon.setImageDrawable(attributes.getDrawable(R.styleable.PairView_icon))

        attributes.recycle()

    }



}