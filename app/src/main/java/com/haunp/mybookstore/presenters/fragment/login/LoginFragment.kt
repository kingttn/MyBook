package com.haunp.mybookstore.presenters.fragment.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.haunp.mybookstore.databinding.FragmentLoginBinding
import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.presenters.BookStoreManager
import com.haunp.mybookstore.presenters.base.BaseFragment
import com.haunp.mybookstore.presenters.fragment.admin.book.BookFragment
import com.haunp.mybookstore.presenters.fragment.main.MainActivity
import com.haunp.mybookstore.presenters.fragment.register.RegisterFragment
import com.haunp.mybookstore.presenters.fragment.user.home.HomeFragment
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
            if (it != null) {
                Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                (activity as MainActivity).showFragment(BookFragment())
                settingViewModel?.setUser(it)
                BookStoreManager.idUser = it.userId
            }
        }
        binding {
            btnLogin.setOnClickListener {
                val username = edtUsername.text.toString().trim()
                val password = edtPassword.text.toString().trim()
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(context,"Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                else if(username == "admin" && password == "admin"){
                    Log.d("LoginFragment", "username: $username, password: $password")
                    (activity as MainActivity).showFragment(BookFragment())
                    settingViewModel?.setUser(UserEntity(99, password,"admin","admin","admin", "admin",0))
                }
                else {
                    Log.d("LoginUser", "username: $username, password: $password")
                    viewModel.checkUserCredentials(username, password)
                }
                viewModel.login(username, password)
            }

            // Nút chuyển sang RegisterFragment
            btnSwitchToRegister.setOnClickListener {
                (activity as MainActivity).showFragment(RegisterFragment())
            }
        }
    }
}
