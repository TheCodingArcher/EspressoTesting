package android.the.coding.archer.espressotesting

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun toolbarTitle() {
        /*onView(
            allOf(
                isAssignableFrom(TextView::class.java),
                withParent(isAssignableFrom(Toolbar::class.java))
            )
        ).check(matches(withText(R.string.title)))*/

        // Testing our Custom made withTootbarTitle()
        val title = InstrumentationRegistry.getTargetContext().getString(R.string.title)

        onView(isAssignableFrom(Toolbar::class.java))
            .check(matches(withToolbarTitle(title)))
    }

    private fun withToolbarTitle(expectedTitle: CharSequence): Matcher<View> {
        return object : BoundedMatcher<View, Toolbar>(Toolbar::class.java) {
            override fun describeTo(description: Description?) {
                description?.appendText("with Toolbar Title: " + expectedTitle)
            }

            override fun matchesSafely(toolbar: Toolbar?): Boolean {
                return expectedTitle == toolbar?.title
            }

        }
    }
}