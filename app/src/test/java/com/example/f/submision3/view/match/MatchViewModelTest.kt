package com.example.f.submision3.view.match

import com.example.f.submision3.repository.MatchRepository
import com.example.f.submision3.util.SchedulerProviders
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MatchViewModelTest {

//    @Mock
//    lateinit var matchRepoTest:MatchRepository
//
//      kenapa klo pake @mock dia return NullPointerException ?
//      errornya itu matchRepository di class MatchViewModel tidak terinisialisasi
//      akhirnya saya pake @spy dan berhasil

    @Spy
    lateinit var matchRepoTest:MatchRepository

    lateinit var viewModel:MatchViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        //inisialisasi viewModel
        viewModel = MatchViewModel(matchRepoTest)

        //ganti scheduler ke trampoline untuk rxjava
        viewModel.matchRepository.matchRemoteData.providerSchedulers =
                SchedulerProviders.TrampolineSchedulerProvider()
    }

    @Test
    fun `testing getNextMatch di class MatchViewModel apakah sama dengan yang di repository`() {

        //cek fungsi getNextMatch di viewModel
        viewModel.getNextMatch()

        //verifikasi fungsi getNextMatch di viewModel == yg di repository
        verify(matchRepoTest).getNextMatch()

    }

    @Test
    fun `testing getLastMatch di class MatchViewModel apakah sama dengan yang di repository`() {
        //cek fungsi getNextMatch di viewModel
        viewModel.getLastMatch()

        //verifikasi fungsi getNextMatch di viewModel == yg di repository
        verify(matchRepoTest).getLastMatch()
    }

}