package com.haunp.mybookstore.presenters.fragment.admin.category_admin

import com.haunp.mybookstore.databinding.CategoryAdminFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment

class CategoryAdminFragment : BaseFragment<CategoryAdminFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): CategoryAdminFragmentBinding {
        return CategoryAdminFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }
}