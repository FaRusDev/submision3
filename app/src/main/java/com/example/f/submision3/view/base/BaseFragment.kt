package com.example.f.submision3.view.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.f.submision3.di.DaggerApp
import com.example.f.submision3.di.component.ComponentDagger
import kotlinx.android.synthetic.main.fragment_match.*

abstract class BaseFragment<B:ViewDataBinding,V:BaseViewModel>:Fragment() {
    lateinit var mainBinding:B
    lateinit var viewModel: V

    lateinit var viewBinding:View
    abstract fun inject(componentDagger: ComponentDagger)

    abstract fun setLayoutResource():Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        //inject dari dagger
        val componentDagger = DaggerApp.componentDagger
        //fungsi ini dari kelas ini
        inject(componentDagger)

        //databinding resourcenya nanti diinisalisasi di mainactivity
        mainBinding = DataBindingUtil.inflate(inflater,setLayoutResource(),container,false)
        viewBinding = mainBinding.root

        code()

        return viewBinding
    }

    abstract fun code()



}