package com.mahdid.o.taha.jerusalemguide

import com.mahdid.o.taha.jerusalemguide.DBHelper.DBHelper
import org.junit.*
import org.junit.Assert.*

import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import java.lang.AssertionError
import kotlin.properties.Delegates

@RunWith(RobolectricTestRunner::class)
class NewsTest {
    lateinit var dbHelper: DBHelper
    var newsListSize by Delegates.notNull<Int>()

    @Before
    fun setUp() {
        dbHelper = DBHelper(RuntimeEnvironment.systemContext.applicationContext)
//        dbHelper.add_news("aa","aa","aa","aa","aa")
//        dbHelper.update_news("aa","aa","aa","aa","aa")
        newsListSize = dbHelper.get_news().size
    }


    @Test(expected = AssertionError::class)
    fun newsListSize() {
        assertNotEquals(0, newsListSize)
    }

    @After
    fun tearDown() {
        dbHelper.close()
    }


    companion object {
        @JvmStatic
        @BeforeClass
        fun setup() {
        }

        @JvmStatic
        @AfterClass
        fun teardown() {
        }
    }
}