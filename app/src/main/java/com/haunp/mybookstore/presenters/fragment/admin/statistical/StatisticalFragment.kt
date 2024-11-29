package com.haunp.mybookstore.presenters.fragment.admin.statistical

import com.haunp.mybookstore.databinding.StatisticalFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment

class StatisticalFragment : BaseFragment<StatisticalFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): StatisticalFragmentBinding {
        return StatisticalFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }
}