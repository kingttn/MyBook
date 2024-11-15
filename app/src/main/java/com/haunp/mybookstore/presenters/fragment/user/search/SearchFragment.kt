package com.haunp.mybookstore.presenters.fragment.user.search

import com.haunp.mybookstore.databinding.SearchFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment

class SearchFragment: BaseFragment<SearchFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean
        = true

    override fun getDataBinding(): SearchFragmentBinding {
        return SearchFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }

}