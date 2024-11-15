package com.haunp.mybookstore.presenters.fragment.user.home

import com.haunp.mybookstore.databinding.HomeFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment


class HomeFragment : BaseFragment<HomeFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }


}