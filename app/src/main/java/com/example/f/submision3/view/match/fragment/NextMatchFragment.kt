package com.example.f.submision3.view.match.fragment

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.example.f.submision3.R
import com.example.f.submision3.databinding.FragmentMatchBinding
import com.example.f.submision3.di.component.ComponentDagger
import com.example.f.submision3.repository.MatchRepository
import com.example.f.submision3.util.CustomViewModelFactory
import com.example.f.submision3.view.base.BaseFragment
import com.example.f.submision3.view.match.MatchViewModel

class NextMatchFragment:BaseFragment<FragmentMatchBinding, MatchViewModel>() {
    override fun inject(componentDagger: ComponentDagger) {
        componentDagger.inject(this)
    }

    override fun setLayoutResource(): Int = R.layout.fragment_match

    override fun code() {
        mainBinding.setLifecycleOwner(this)

        val matchRepository = MatchRepository()

        //setViewModel
        viewModel = ViewModelProviders.of(this,CustomViewModelFactory(matchRepository)).get(MatchViewModel::class.java)

        //set variable untuk xml
        mainBinding.mainMatch = viewModel

        mainBinding.recyclerView.layoutManager = LinearLayoutManager(viewBinding.context)

        viewModel.getNextMatch()
    }
}