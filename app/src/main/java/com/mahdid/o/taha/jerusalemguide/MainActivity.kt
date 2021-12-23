package com.mahdid.o.taha.jerusalemguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mahdid.o.taha.jerusalemguide.fragments.App.History
import com.mahdid.o.taha.jerusalemguide.fragments.App.Home
import com.mahdid.o.taha.jerusalemguide.fragments.App.News
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(mainOnNavigationItemSelectedListener)
        bottom_navigation.selectedItemId = R.id.home
    }
    private val mainOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                transaction(Home())
                true
            }
            R.id.news -> {
                transaction(News())
                true
            }

            R.id.history -> {
                transaction(History())
                true
            }
            else -> false
        }
    }

    private fun transaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
