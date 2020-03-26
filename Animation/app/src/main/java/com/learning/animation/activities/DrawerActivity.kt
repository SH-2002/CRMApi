package com.learning.animation.activities

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.marginStart
import androidx.core.view.setMargins
import androidx.drawerlayout.widget.DrawerLayout
import com.learning.animation.R
import kotlinx.android.synthetic.main.activity_drawer.*

class DrawerActivity : AppCompatActivity() {

    private val TAG = DrawerActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        drawerLayout.setScrimColor(ContextCompat.getColor(this, android.R.color.transparent))
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toggler.setOnClickListener {
            if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.openDrawer(nav_view)
                val params = DrawerLayout.LayoutParams(DrawerLayout.LayoutParams.MATCH_PARENT,DrawerLayout.LayoutParams.MATCH_PARENT)
                params.setMargins((nav_view.measuredWidth)+20,0,0,0)
                view.layoutParams = params
                Log.e(TAG,"Drawer width = ${nav_view.measuredWidth}")
            }else{

                val params = DrawerLayout.LayoutParams(DrawerLayout.LayoutParams.MATCH_PARENT,DrawerLayout.LayoutParams.MATCH_PARENT)
                params.setMargins(0)
                view.layoutParams = params
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }

    }
}
