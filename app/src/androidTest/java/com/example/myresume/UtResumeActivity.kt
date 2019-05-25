package com.example.myresume

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.myresume.MockResumeInformationRepository.Companion.BASICS_NAME
import com.example.myresume.MockResumeInformationRepository.Companion.BASICS_PROFILE
import com.example.myresume.MockResumeInformationRepository.Companion.JOB_NAME
import com.example.myresume.domain.interactors.GetResumeInteractor
import com.example.myresume.domain.resolver.StringsResolver
import com.example.myresume.view.ResumeActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject


@RunWith(AndroidJUnit4::class)
class UtResumeActivity {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(ResumeActivity::class.java, true, false)

    @Inject
    lateinit var stringsResolver: StringsResolver
    @Inject
    lateinit var getResumeInteractor: GetResumeInteractor

    @Before
    fun setupForTests() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as ResumeApplication
        val component = app.getAppComponent() as MockAppComponent
        component.inject(this)

        activityRule.launchActivity(Intent())
    }

    @Test
    fun testHeaderHasInformation() {
        Espresso.onView(withId(R.id.tv_profile_description))
            .check(matches(ViewMatchers.withText(BASICS_PROFILE)))
    }

    @Test
    fun testInfoContainerIsVisible() {
        Espresso.onView(withId(R.id.info_container))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun testTextInWorksListElement() {
        Espresso.onView(withId(R.id.work_experience_list))
            .check(matches(positionMatcher(0, hasDescendant(withText(JOB_NAME)))))
    }

    @Test
    fun testsVerifyUserName() {
        Espresso.onView(withId(R.id.tv_profile_name))
            .check(matches(withText(BASICS_NAME)))
    }

    @Test
    fun testProgressbarGone() {
        Espresso.onView(withId(R.id.lottie_loading))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
    }


    fun positionMatcher(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("the list has an item in the position $position: ")
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val viewHolder = view.findViewHolderForAdapterPosition(position)
                    ?: return false
                return itemMatcher.matches(viewHolder.itemView)
            }
        }
    }
}