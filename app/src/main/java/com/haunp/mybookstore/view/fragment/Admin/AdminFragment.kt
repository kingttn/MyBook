package com.haunp.mybookstore.view.fragment.Admin

import com.haunp.mybookstore.databinding.AdminFragmentBinding
import com.haunp.mybookstore.view.base.BaseFragment
import com.haunp.mybookstore.view.fragment.login_register.UserViewModel

class AdminFragment:BaseFragment<AdminFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true


    override fun getDataBinding(): AdminFragmentBinding {
        return AdminFragmentBinding.inflate(layoutInflater)
    }

}