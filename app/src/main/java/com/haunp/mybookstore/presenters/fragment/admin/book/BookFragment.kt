package com.haunp.mybookstore.presenters.fragment.admin.book

import com.haunp.mybookstore.databinding.BookFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment

class BookFragment : BaseFragment<BookFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): BookFragmentBinding {
        return BookFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }


}