package com.haunp.mybookstore.view.fragment.User.search

import com.haunp.mybookstore.databinding.SearchFragmentBinding
import com.haunp.mybookstore.view.base.BaseFragment

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