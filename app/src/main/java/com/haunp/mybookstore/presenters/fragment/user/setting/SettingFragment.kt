package com.haunp.mybookstore.presenters.fragment.user.setting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.haunp.mybookstore.databinding.SettingFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment
import com.haunp.mybookstore.presenters.fragment.login.LoginFragment
import com.haunp.mybookstore.presenters.fragment.main.MainActivity

class SettingFragment: BaseFragment<SettingFragmentBinding>() {
    private lateinit var settingViewModel: SettingViewModel
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): SettingFragmentBinding {
        return SettingFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingViewModel = ViewModelProvider(this)[SettingViewModel::class.java]
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initView() {
        settingViewModel.user.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                binding.btnLogin.visibility = View.GONE
                binding.tvUsername.visibility = View.VISIBLE
                binding.btnLogout.visibility = View.GONE
            } else if(user == null){
                binding.btnLogin.visibility = View.GONE
                binding.tvUsername.visibility = View.VISIBLE
                binding.btnLogout.visibility = View.GONE
            }
            else {
                binding.btnLogin.visibility = View.VISIBLE
                binding.tvUsername.visibility = View.GONE
            }
        }
        binding {
            btnLogin.setOnClickListener {
                (activity as MainActivity).showFragment(LoginFragment())
            }
            btnLogout.setOnClickListener{
                settingViewModel.logout()
            }
        }
    }
}