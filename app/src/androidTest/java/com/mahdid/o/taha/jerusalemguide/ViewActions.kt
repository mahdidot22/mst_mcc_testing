package com.mahdid.o.taha.jerusalemguide

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mahdid.o.taha.jerusalemguide.fragments.App.News
import com.mahdid.o.taha.jerusalemguide.introSlider.IntroSliderActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewActions {

//    @get:Rule
//    val mActivityRule: ActivityScenarioRule<IntroSliderActivity> = ActivityScenarioRule(IntroSliderActivity::class.java)

    @get:Rule
    val rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
//        mActivityRule.scenario.onActivity {
//        }
        rule.scenario.onActivity {
            it.supportFragmentManager.beginTransaction().replace(R.id.container,News()).commit()
        }
    }
//    @Test
//    fun nextClicked(){
//        onView(withId(R.id.btn_next)).perform(click())
//    }
//    @Test
//    fun skipLongClicked(){
//        onView(withId(R.id.skip)).perform(longClick())
//    }
    @Test
    fun swipeU(){
        onView(withId(R.id.news_list)).perform(swipeUp())
    }
    @Test
    fun swipeD(){
        onView(withId(R.id.news_list)).perform(swipeDown())
    }

}