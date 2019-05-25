package com.example.myresume

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.myresume.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTests {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun testHeaderHasInformation() {
        
    }
}