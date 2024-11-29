package com.haunp.mybookstore.presenters.fragment.admin.user

import com.haunp.mybookstore.databinding.UserFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment

class UserFragment : BaseFragment<UserFragmentBinding>(){
    override var isTerminalBackKeyActive: Boolean = true
    override fun getDataBinding(): UserFragmentBinding{
        return UserFragmentBinding.inflate(layoutInflater)
    }
    override fun initView() {
        super.initView()
    }
}