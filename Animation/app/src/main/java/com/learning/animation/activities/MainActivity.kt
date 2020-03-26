package com.learning.animation.activities

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.learning.animation.R
import com.learning.animation.fragments.ChatFragment
import com.learning.animation.fragments.HomeFragment
import com.learning.animation.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private var viewHeight: Int = -1603

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav.setOnNavigationItemSelectedListener(bottomNavigationListener)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment()).commit()
        slider.setOnClickListener { bottomNavBarListener()
        startActivity(Intent(this,DrawerActivity::class.java))}
    }

    private fun bottomNavBarListener() {
        val view: BottomNavigationView = bottomNav
        if (viewHeight == -1603) {
            viewHeight = view.measuredHeight
        }
        if (view.height == 0) {
            val anim: ValueAnimator = ValueAnimator.ofInt(view.height, viewHeight)
            anim.addUpdateListener {
                val param = view.layoutParams
                param.height = it.animatedValue as Int
                view.layoutParams = param
            }
            anim.duration = 300
            anim.start()
        } else {
            val anim: ValueAnimator = ValueAnimator.ofInt(view.measuredHeight, 0)
            anim.addUpdateListener {
                val param = view.layoutParams
                param.height = it.animatedValue as Int
                view.layoutParams = param
            }
            anim.duration = 300
            anim.start()
        }
    }

    private val bottomNavigationListener: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.home -> HomeFragment()
                R.id.chat -> ChatFragment()
                R.id.search -> SearchFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, selectedFragment).commit()
            true
        }
}
