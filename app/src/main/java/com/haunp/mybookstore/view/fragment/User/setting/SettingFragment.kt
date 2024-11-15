package com.haunp.mybookstore.view.fragment.User.setting

import com.haunp.mybookstore.MainActivity
import com.haunp.mybookstore.databinding.SettingFragmentBinding
import com.haunp.mybookstore.view.base.BaseFragment
import com.haunp.mybookstore.view.fragment.login_register.LoginFragment

class SettingFragment: BaseFragment<SettingFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): SettingFragmentBinding {
        return SettingFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding { 
            tvClickLogin.setOnClickListener {
                (activity as MainActivity).showFragment(LoginFragment())
            }
        }
    }
}