package com.example.f.submision3.view.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.f.submision3.di.DaggerApp
import com.example.f.submision3.di.component.ComponentDagger

abstract class BaseActivity<B:ViewDataBinding,V:BaseViewModel>:AppCompatActivity() {

    lateinit var mainBinding:B
    lateinit var viewModel: V
    abstract fun inject(componentDagger: ComponentDagger)

    abstract fun setLayoutResource():Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inject dari dagger
        val componentDagger = DaggerApp.componentDagger
        //fungsi ini dari kelas ini
        inject(componentDagger)

        //databinding resourcenya nanti diinisalisasi di mainactivity
        mainBinding = DataBindingUtil.setContentView(this,setLayoutResource())

        code()
    }

    abstract fun code()

}