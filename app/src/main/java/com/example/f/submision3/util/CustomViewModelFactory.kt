package com.example.f.submision3.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.f.submision3.repository.MatchRepository
import com.example.f.submision3.view.match.MatchViewModel

class CustomViewModelFactory(private val matchRepository: MatchRepository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MatchViewModel(matchRepository) as T
    }
}