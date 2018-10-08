package com.example.f.submision3.view.match

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.f.submision3.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestActivity{
    @Rule
    @JvmField
    var activityTest = ActivityTestRule(MainActivity::class.java)

    @Test
    fun recyClerViewBehav(){

        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions
                .scrollToPosition<RecyclerView.ViewHolder>(5))
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, ViewActions.click())
        )
    }

    @Test
    fun addedToFavorite(){

        recyClerViewBehav()

        //ini akan error kalo sudah terpilih jadi favorite

        //sdh coba pake trycatch tetap error ifElse jg tdk bisa dipake
        //apa ada caranya agar klo sudah terpilih jadi favorite bisa di klik lebih dulu
//
//        onView(withId(R.id.add_to_fav)).check(matches(isDisplayed()))
//        onView(withId(R.id.add_to_fav)).check(matches(isEnabled()))
//
//       bru di atur disiini kondisinya
//
//       onView(withId(R.id.add_to_fav)).perform(click())

        Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).check(ViewAssertions.matches(ViewMatchers.isEnabled()))


        Espresso.pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.favouriteMatchMenu)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.favouriteMatchMenu)).perform(ViewActions.click())

        //cek apakah di favorite recyclerView itu menampilkan data dari yang terpilih
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        //      saya mau cek juga apakah add_to_fav tercentang atau tidak tapi kena error sedangkan
//        klo dijalankan tidak ada masalah dengan kode dibawah ini
//
//        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions
//                .scrollToPosition<RecyclerView.ViewHolder>(1))
//        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(
//                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, ViewActions.click()))
//
//        Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).check(ViewAssertions.matches(ViewMatchers.isEnabled()))

    }

}