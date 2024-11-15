package com.haunp.mybookstore.presenters.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.haunp.mybookstore.databinding.FragmentLoginBinding
import com.haunp.mybookstore.presenters.base.BaseFragment
import com.haunp.mybookstore.presenters.fragment.main.MainActivity
import com.haunp.mybookstore.presenters.fragment.register.RegisterFragment
import com.haunp.mybookstore.presenters.fragment.user.setting.SettingViewModel
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override var isTerminalBackKeyActive: Boolean = false

    private val viewModel: LoginViewModel by inject()
    private var settingViewModel: SettingViewModel? = null

    override fun getDataBinding(): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingViewModel = ViewModelProvider(requireActivity())[SettingViewModel::class.java]
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initView() {
        viewModel.loginResult.observe(viewLifecycleOwner) {
            settingViewModel?.setUser(it)
        }
        binding {
            btnLogin.setOnClickListener {
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()
                viewModel.login(username, password)
            }

            // Nút chuyển sang RegisterFragment
            btnSwitchToRegister.setOnClickListener {
                (activity as MainActivity).showFragment(RegisterFragment())
            }
        }
    }


}
