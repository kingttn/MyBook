package com.haunp.mybookstore.presenters.fragment.user.category_user

import com.haunp.mybookstore.databinding.CategoryUserFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment

class CategoryUserFragment : BaseFragment<CategoryUserFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): CategoryUserFragmentBinding {
        return CategoryUserFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }


}