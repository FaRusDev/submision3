package com.example.f.submision3.view.match

import com.example.f.submision3.repository.MatchRepository
import com.example.f.submision3.util.SchedulerProviders
import com.example.f.submission3.model.Match
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MatchViewModelTest {

    val viewModel = MatchViewModel()

    @Mock val matchRepository = MatchRepository()

    val testObserver = TestObserver<Match>()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        //ganti scheduler ke trampoline untuk rxjava
        viewModel.matchRepository.matchRemoteData.providerSchedulers =
                SchedulerProviders.TrampolineSchedulerProvider()

    }

    @Test
    fun getNextMatch() {
        //cek fungsi getNextMatch di viewModel
        viewModel.getNextMatch()

        //cek apakah isi dari class Match itu berubah dari subscription
        testObserver.hasSubscription()

        //cek apakah yg di viewmodel sama dengan yg di matchRepository
        assert(matchRepository.getNextMatch() == viewModel.getNextMatch())
    }

    @Test
    fun getLastMatch(){
        //cek fungsi getLastMatch di viewModel
        viewModel.getLastMatch()

        //cek apakah isi dari class Match itu berubah dari subscription
        testObserver.hasSubscription()

        //cek apakah yg di viewmodel sama dengan yg di matchRepository
        assert(matchRepository.getLastMatch() == viewModel.getLastMatch())
    }
}