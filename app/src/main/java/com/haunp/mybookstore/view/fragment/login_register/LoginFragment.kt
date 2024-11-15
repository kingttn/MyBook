package com.haunp.mybookstore.view.fragment.login_register

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.haunp.mybookstore.MainActivity
import com.haunp.mybookstore.data.local.db.AppDatabase
import com.haunp.mybookstore.data.repository.UserRepository
import com.haunp.mybookstore.databinding.FragmentLoginBinding
import com.haunp.mybookstore.view.base.BaseFragment
import com.haunp.mybookstore.view.fragment.Admin.AdminFragment
import com.haunp.mybookstore.view.fragment.User.main.HomeFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override var isTerminalBackKeyActive: Boolean = false

    private lateinit var userViewModel: UserViewModel

    override fun getDataBinding(): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val database = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
        val userDao = database.userDao()
        val repository = UserRepository(userDao)
        userViewModel = ViewModelProvider(this, UserViewModelFactory(repository))
            .get(UserViewModel::class.java)
        userViewModel.registerAdmin("admin", "admin", "admin", "admin", "admin")
    }
    override fun initView() {
        binding {
            btnLogin.setOnClickListener {
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()

                if (username.isNotEmpty() && password.isNotEmpty()) {
                    userViewModel.login(username, password) { user ->
                        if (user != null) {
                            // Kiểm tra quyền và chuyển hướng
                            if (user.role == true) {
                                // Chuyển đến HomeFragment cho user
                                Toast.makeText(context, "Login Admin Successful", Toast.LENGTH_SHORT).show()
                                (activity as MainActivity).showFragment(AdminFragment())
                            } else {
                                // Chuyển đến AdminFragment cho admin
                                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                                (activity as MainActivity).showFragment(HomeFragment())
                            }
                        } else {
                            Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(context, "Please enter both username and password", Toast.LENGTH_SHORT).show()
                }
            }

            // Nút chuyển sang RegisterFragment
            btnSwitchToRegister.setOnClickListener {
                (activity as MainActivity).showFragment(RegisterFragment())
            }
        }
    }
}
