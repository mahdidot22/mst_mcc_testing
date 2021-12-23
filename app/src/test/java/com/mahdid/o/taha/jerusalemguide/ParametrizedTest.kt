package com.mahdid.o.taha.jerusalemguide

import com.mahdid.o.taha.jerusalemguide.DBHelper.DBHelper
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import org.robolectric.RuntimeEnvironment


@RunWith(ParameterizedRobolectricTestRunner::class)
class ParametrizedTest(
    var expectedResult: Int,
    var actualResult: Int
) {
    lateinit var dbHelper: DBHelper

    @Before
    fun setUp() {
//        dbHelper = DBHelper(RuntimeEnvironment.systemContext.applicationContext)
//        dbHelper.add_recent_news("title","urlToImg")
//        dbHelper.add_recent_news("title","urlToImg")
//        dbHelper.add_recent_news("title","urlToImg")
    }

    companion object {
        @ParameterizedRobolectricTestRunner.Parameters
        @JvmStatic
        fun data(): Collection<*> {
            return listOf(
                arrayOf(3,0),
            )
        }
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    @Throws(Exception::class)
    fun currentNewsCount() {
        Assert.assertEquals(
            expectedResult,
            dbHelper.get_recent_news().size
            )
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun newsCount(){
        Assert.assertEquals(expectedResult,dbHelper.get_news().size)
    }

    @After
    fun teardown() {
        dbHelper.close()
    }
}

