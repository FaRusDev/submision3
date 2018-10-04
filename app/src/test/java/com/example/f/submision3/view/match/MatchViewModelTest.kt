package com.example.f.submision3.view.match

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.EventLog
import com.example.f.submision3.data.local.DbOpenHelper
import com.example.f.submision3.data.remote.MatchRemoteData
import com.example.f.submision3.di.DaggerApp
import com.example.f.submision3.di.module.NetworkModule
import com.example.f.submision3.repository.MatchRepository
import com.example.f.submission3.model.EventsItem
import com.example.f.submission3.model.Match
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Predicate
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MatchViewModelTest {

    @Mock
    val matchRepository = MatchRepository()

    @Mock
    val view = MainActivity()

    @Mock
    val detailActivity = DetailActivity()

    @Mock
    val match = Match()

    val viewModel = MatchViewModel()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getNextMatch() {
//        val observer = TestObserver<Match>()
//
//        Mockito.`when`(matchRepository.getNextMatch()).thenReturn(viewModel.getNextMatch())
//
//        viewModel.getNextMatch()
//
//        Mockito.verify(observer).assertNoErrors()
//        Mockito.verify(view).viewModel.loading.equals(true)
    }

    @Test
    fun addToFav() {
//        val observer = TestObserver<Match>()
//        viewModel.addToFav(DbOpenHelper(detailActivity.applicationContext),
//                detailActivity.applicationContext,match.events?.get(0)!!)
//
//        Mockito.verify(match.events)?.get(0)
//        Mockito.verify(observer).assertNoErrors()
    }

    @Test
    fun removeFromFav() {
    }

    @Test
    fun favoriteState() {
    }
}