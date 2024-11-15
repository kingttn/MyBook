package com.haunp.mybookstore.presenters.fragment.admin

import com.haunp.mybookstore.databinding.AdminFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment

class AdminFragment:BaseFragment<AdminFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true


    override fun getDataBinding(): AdminFragmentBinding {
        return AdminFragmentBinding.inflate(layoutInflater)
    }

}