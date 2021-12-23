package com.mahdid.o.taha.jerusalemguide.introSlider

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mahdid.o.taha.jerusalemguide.MainActivity
import com.mahdid.o.taha.jerusalemguide.R
import com.mahdid.o.taha.jerusalemguide.adapter.IntroSliderAdapter
import com.mahdid.o.taha.jerusalemguide.fragments.introSlider.Intro1Fragment
import com.mahdid.o.taha.jerusalemguide.fragments.introSlider.Intro2Fragment
import com.mahdid.o.taha.jerusalemguide.fragments.introSlider.Intro3Fragment
import kotlinx.android.synthetic.main.activity_intro_slider.*

class IntroSliderActivity : AppCompatActivity() {
    private val fragmentlist = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_slider)

        setContentView(R.layout.activity_intro_slider)
        val adapter = IntroSliderAdapter(this)
        VPIntroSlider.adapter = adapter

        fragmentlist.addAll(listOf(Intro1Fragment(), Intro2Fragment(), Intro3Fragment()))
        adapter.setFragmentList(fragmentlist)

        indicatorLayout.setIndicatorCount(adapter.itemCount)
        indicatorLayout.selectCurrentPosition(0)

        registerListeners()
    }
    private fun registerListeners() {
        VPIntroSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                indicatorLayout.selectCurrentPosition(position)

                if (position < fragmentlist.lastIndex) {
                    skip.visibility = View.VISIBLE
                    btn_next.text = "التالي"
                } else {
                    skip.visibility = View.GONE
                    btn_next.text = "إلى الرئيسية"
                }
            }
        })

        skip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_next.setOnClickListener {
            val position = VPIntroSlider.currentItem

            if (position < fragmentlist.lastIndex) {
                VPIntroSlider.currentItem = position + 1
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
