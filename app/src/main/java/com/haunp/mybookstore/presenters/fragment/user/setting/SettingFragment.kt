package com.haunp.mybookstore.presenters.fragment.user.setting

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.haunp.mybookstore.databinding.SettingFragmentBinding
import com.haunp.mybookstore.presenters.CoreViewModel
import com.haunp.mybookstore.presenters.base.BaseFragment
import com.haunp.mybookstore.presenters.fragment.login.LoginFragment
import com.haunp.mybookstore.presenters.fragment.main.MainActivity

class SettingFragment : BaseFragment<SettingFragmentBinding>() {
    //shareViewModel
    private val coreViewModel: CoreViewModel by activityViewModels()
    private val settingViewModel: SettingViewModel by viewModels()
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): SettingFragmentBinding {
        return SettingFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        settingViewModel.user.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                binding.btnLogin.visibility = View.GONE
                binding.tvUsername.visibility = View.VISIBLE
                binding.btnLogout.visibility = View.VISIBLE
            } else {
                binding.btnLogin.visibility = View.VISIBLE
                binding.tvUsername.visibility = View.GONE
                binding.btnLogout.visibility = View.GONE
            }
        }
        binding {
            btnLogin.setOnClickListener {
                (activity as MainActivity).showFragment(LoginFragment())
            }
            btnLogout.setOnClickListener {
                settingViewModel.logout()
            }
        }
    }
}