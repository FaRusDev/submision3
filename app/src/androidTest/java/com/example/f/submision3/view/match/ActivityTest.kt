package com.example.f.submision3.view.match

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.f.submision3.R.id.*
import com.example.f.submision3.data.remote.MatchRemoteData
import com.example.f.submission3.model.Match
import com.example.f.submission3.model.Team
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityTest {
    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)
    val remoteData = object : MatchRemoteData() {
        override fun subscribeTeamSuccess(team: Team) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onSubscribe() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onCompleteSubscribe() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun subscribeSuccess(match: Match) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    @Test
    fun recyclerViewBehav(){
        //penambahan idling resouce untuk cek asynchronus
        registerIdlingResources(remoteData.idlingResource)
        onView(withId(recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun addToFavFromNextMatch(){


        onView(withId(nextMatchMenu)).check(matches(isDisplayed()))
        onView(withId(nextMatchMenu)).perform(click())

        recyclerViewBehav()
        onView(withId(recyclerView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
        onView(withId(recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                10,click()
        ))

        onView(withId(add_to_fav)).check(matches(isDisplayed()))
        onView(withId(add_to_fav)).perform(click())

        Espresso.pressBack()

        recyclerViewBehav()

    }

    @Test
    fun addToFavFromLastMatch(){
        onView(withId(lastMatchMenu)).check(matches(isDisplayed()))
        onView(withId(lastMatchMenu)).perform(click())

        recyclerViewBehav()
        onView(withId(recyclerView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
        onView(withId(recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                10,click()
        ))

        onView(withId(add_to_fav)).check(matches(isDisplayed()))
        onView(withId(add_to_fav)).perform(click())

        Espresso.pressBack()

        recyclerViewBehav()
    }

    @Test
    fun removeFromFav(){
        onView(withId(favouriteMatchMenu)).check(matches(isDisplayed()))
        onView(withId(favouriteMatchMenu)).perform(click())

        onView(withId(recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,click()
        ))

        onView(withId(add_to_fav)).check(matches(isEnabled()))
        onView(withId(add_to_fav)).perform(click())

    }
}