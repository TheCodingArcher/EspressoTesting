package android.the.coding.archer.espressotesting

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clickItem() {
        onView(withId(R.id.footer))
            .check(matches(not(isDisplayed())))
    }

    private fun withValue(value: Int): Matcher<Any> {
        return object : BoundedMatcher<Any, MainActivity.Item>(MainActivity.Item::class.java) {
            override fun describeTo(description: Description?) {
                description?.appendText("has value: " + value)
            }

            override fun matchesSafely(item: MainActivity.Item?): Boolean {
                return item.toString() == value.toString()
            }

        }
    }
}