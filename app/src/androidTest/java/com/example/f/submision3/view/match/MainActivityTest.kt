package com.example.f.submision3.view.match


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import com.example.f.submision3.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    //ambil urutan ketiga dari recyclerview trus ke detailActivity
    @Test
    fun mainActivityTest() {
        val recyclerView = onView(
                allOf(withId(R.id.recyclerView),
                        childAtPosition(
                                withClassName(`is`("android.support.constraint.ConstraintLayout")),
                                1)))
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(3, click()))

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)


        //tambahkan ke favorite
        val actionMenuItemView = onView(
                allOf(withId(R.id.add_to_fav), withContentDescription("fav"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        2),
                                0),
                        isDisplayed()))
        actionMenuItemView.perform(click())

        //kembali ke fragment awal
        val appCompatImageButton = onView(
                allOf(withContentDescription("Navigasi naik"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()))
        appCompatImageButton.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        //pindah  ke menubutton last match
        val bottomNavigationItemView = onView(
                allOf(withId(R.id.lastMatchMenu),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_nav_view),
                                        0),
                                1),
                        isDisplayed()))
        bottomNavigationItemView.perform(click())

        //ambil posisi pertama dari recycler view untuk diteruskan ke detailActivity
        val recyclerView2 = onView(
                allOf(withId(R.id.recyclerView),
                        childAtPosition(
                                withClassName(`is`("android.support.constraint.ConstraintLayout")),
                                1)))
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(4, click()))

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        //tambahkan ke favorite
        val actionMenuItemView2 = onView(
                allOf(withId(R.id.add_to_fav), withContentDescription("fav"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        2),
                                0),
                        isDisplayed()))
        actionMenuItemView2.perform(click())

        //kembali ke fragment awal (last Match)
        val appCompatImageButton2 = onView(
                allOf(withContentDescription("Navigasi naik"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()))
        appCompatImageButton2.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)


        //ke menu favorite match
        val bottomNavigationItemView2 = onView(
                allOf(withId(R.id.favouriteMatchMenu),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_nav_view),
                                        0),
                                2),
                        isDisplayed()))
        bottomNavigationItemView2.perform(click())

        //pindah ke detail activity dari posisi recyclerview yg pertama
        val recyclerView3 = onView(
                allOf(withId(R.id.recyclerView),
                        childAtPosition(
                                withClassName(`is`("android.support.constraint.ConstraintLayout")),
                                1)))
        recyclerView3.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        //hapus dari favorite
        val actionMenuItemView3 = onView(
                allOf(withId(R.id.add_to_fav), withContentDescription("fav"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        2),
                                0),
                        isDisplayed()))
        actionMenuItemView3.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        //kembali ke lastmatch menu
        val bottomNavigationItemView3 = onView(
                allOf(withId(R.id.lastMatchMenu),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_nav_view),
                                        0),
                                1),
                        isDisplayed()))
        bottomNavigationItemView3.perform(click())

        //ambil item yang sudah jadi favorite tadi (posisi ke 4)
        val recyclerView4 = onView(
                allOf(withId(R.id.recyclerView),
                        childAtPosition(
                                withClassName(`is`("android.support.constraint.ConstraintLayout")),
                                1)))
        recyclerView4.perform(actionOnItemAtPosition<ViewHolder>(4, click()))

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        //hapus dari favorite
        val actionMenuItemView4 = onView(
                allOf(withId(R.id.add_to_fav), withContentDescription("fav"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        2),
                                0),
                        isDisplayed()))
        actionMenuItemView4.perform(click())
    }

    //posisi dari child
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

}
