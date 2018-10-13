import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.v7.widget.RecyclerView
import com.example.f.submision3.R
import org.junit.Test

//package com.example.f.submision3.view.match
//
//import android.support.test.espresso.Espresso
//import android.support.test.espresso.action.ViewActions
//import android.support.test.espresso.assertion.ViewAssertions
//import android.support.test.espresso.contrib.RecyclerViewActions
//import android.support.test.espresso.matcher.ViewMatchers
//import android.support.test.rule.ActivityTestRule
//import android.support.test.runner.AndroidJUnit4
//import android.support.v7.widget.RecyclerView
//import com.example.f.submision3.R
//import com.example.f.submision3.network.testNetwork
//import com.example.f.submision3.repository.MatchRepository
//import com.example.f.submision3.util.SchedulerProviders
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.MockitoAnnotations
//import org.mockito.Spy
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//
//@RunWith(AndroidJUnit4::class)
//class TestB{
//    @Rule
//    @JvmField
//    var activityTest = ActivityTestRule(MainActivity::class.java)
//
//    @Spy
//    lateinit var matchRepoTest:MatchRepository
//
//    lateinit var viewModel:MatchViewModel
//
//    @Before
//    fun setUp(){
//        MockitoAnnotations.initMocks(this)
//        viewModel = MatchViewModel(matchRepoTest)
//
//        val retrofit = Retrofit.Builder()
//                .baseUrl("../../resources/json/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build().create(testNetwork::class.java)
//
//        viewModel.matchRepository.matchRemoteData.providerSchedulers =
//                SchedulerProviders.TrampolineSchedulerProvider()
//
//        viewModel.network = retrofit
//
//    }
//
//@Test
//fun recyclerViewBehav(){
//    Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//}
//
//@Test
//fun addToFavFromNextMatch(){
//    Espresso.onView(ViewMatchers.withId(R.id.nextMatchMenu)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    Espresso.onView(ViewMatchers.withId(R.id.nextMatchMenu)).perform(ViewActions.click())
//
//    recyclerViewBehav()
//    Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
//    Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
//            10, ViewActions.click()
//    ))
//
//    Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).perform(ViewActions.click())
//
//    Espresso.pressBack()
//
//    recyclerViewBehav()
//
//}
//
//@Test
//fun addToFavFromLastMatch(){
//    Espresso.onView(ViewMatchers.withId(R.id.lastMatchMenu)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    Espresso.onView(ViewMatchers.withId(R.id.lastMatchMenu)).perform(ViewActions.click())
//
//    recyclerViewBehav()
//    Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
//    Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
//            10, ViewActions.click()
//    ))
//
//    Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).perform(ViewActions.click())
//
//    Espresso.pressBack()
//
//    recyclerViewBehav()
//}
//
//@Test
//fun removeFromFav(){
//    Espresso.onView(ViewMatchers.withId(R.id.favouriteMatchMenu)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    Espresso.onView(ViewMatchers.withId(R.id.favouriteMatchMenu)).perform(ViewActions.click())
//
//    Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
//            0, ViewActions.click()
//    ))
//
//    Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).check(ViewAssertions.matches(ViewMatchers.isEnabled()))
//    Espresso.onView(ViewMatchers.withId(R.id.add_to_fav)).perform(ViewActions.click())
//
//}
//}