package com.mahdid.o.taha.jerusalemguide

import androidx.core.view.get
import androidx.core.view.size
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mahdid.o.taha.jerusalemguide.fragments.App.News
import kotlinx.android.synthetic.main.news_item.view.*
import org.hamcrest.CoreMatchers.*
import org.hamcrest.core.AllOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Rule




class NewRecyclerTest {

    private lateinit var scenario: FragmentScenario<News>
    private val listId = R.id.news_list

//    @get:Rule
//    val mActivityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_MaterialComponents_DayNight)
        scenario.moveToState(Lifecycle.State.STARTED)
//        mActivityRule.scenario.onActivity {
//            it.supportFragmentManager.beginTransaction().replace(R.id.container,News()).commit()
//        }
    }

    @Test
    fun recyclerView_isCorrect() {
        // check Recycler view is visible
        onView(withId(listId))
            .check(matches(isDisplayed()))
    }

    @Test
    fun text_IsDisplayed() {
        // Last item should exist if the list wasn't scrolled down.
        onView(withText("قوات إسرائيلية تقتل فلسطينيا اتهمته بإطلاق النار عليها في الضفة الغربية"))
            .check(matches(not(doesNotExist())))
    }

    @Test
    fun row_Click() {
        onData(AllOf.allOf())
            .inAdapterView(withId(R.id.news_list))
            .atPosition(0)
            .perform(click())
    }

    @Test
    fun list_Scrolls() {
       onData(containsString("القدس"))
           .check(matches(isCompletelyDisplayed()))
    }

    @After
    fun tearDown() {
        scenario.moveToState(Lifecycle.State.RESUMED)
    }
}