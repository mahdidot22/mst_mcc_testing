package com.mahdid.o.taha.jerusalemguide

import android.content.Intent
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test


class IntentTest {
    @get:Rule
    val rule: ActivityScenarioRule<SplashActivity> = ActivityScenarioRule(SplashActivity::class.java)

    @Test
    fun intentTEST(){
        rule.scenario.onActivity {
            it.startActivity(Intent(it,MainActivity::class.java))
        }
    }


}