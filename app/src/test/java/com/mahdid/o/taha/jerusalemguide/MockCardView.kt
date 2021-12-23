package com.mahdid.o.taha.jerusalemguide

import android.graphics.Color
import android.widget.TextView
import androidx.cardview.widget.CardView
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.lang.AssertionError

class MockCardView {
    lateinit var mockedCardView: CardView
    lateinit var mockedTextView: TextView
    private final val actual = "aaa"
    @Test
    fun testMyCardClick(){
        mockedCardView = mock(CardView::class.java)
        mockedCardView.setCardBackgroundColor(Color.GRAY)
        verify(mockedCardView).setCardBackgroundColor(Color.GRAY)
    }


    @Test
    fun testMyTextView(){
        mockedTextView = mock(TextView::class.java)
        Mockito.`when`(mockedTextView.text).thenReturn("test")
        Assert.assertEquals(mockedTextView.text,actual)
    }
}