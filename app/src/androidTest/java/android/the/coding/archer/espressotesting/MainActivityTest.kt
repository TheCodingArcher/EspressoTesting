package android.the.coding.archer.espressotesting

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    // RecyclerView Test
    /*onView(ViewMatcher).perform(RecyclerViewAction)*/

    @Test
    fun clickItem() {
        onView(withId(R.id.footer))
            .check(matches(not(isDisplayed())))
    }
}