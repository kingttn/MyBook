package com.haunp.mybookstore.view.fragment.User.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.haunp.mybookstore.databinding.HomeFragmentBinding
import com.haunp.mybookstore.view.base.BaseFragment


class HomeFragment : BaseFragment<HomeFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }


}