package com.haunp.mybookstore.view.fragment.login_register

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.haunp.mybookstore.MainActivity
import com.haunp.mybookstore.data.local.db.AppDatabase
import com.haunp.mybookstore.data.repository.UserRepository
import com.haunp.mybookstore.databinding.FragmentRegisterBinding
import com.haunp.mybookstore.view.base.BaseFragment

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): FragmentRegisterBinding {
        return FragmentRegisterBinding.inflate(layoutInflater)
    }
    private lateinit var registerViewModel: UserViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val database = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()

        val userDao = database.userDao()
        val repository = UserRepository(userDao)
        registerViewModel = ViewModelProvider(this, UserViewModelFactory(repository))
            .get(UserViewModel::class.java)
    }

    override fun initView() {
        binding {
            btnRegister.setOnClickListener {
                val email = edtUsername.text.toString()
                val username = edtEmail.text.toString()
                val password = edtPassword.text.toString()
                val confirmPassword = edtCfmPassword.text.toString()
                val phone = edtPhone.text.toString()
                val address = edtAddress.text.toString()

                if (email.isNotEmpty() && password.isNotEmpty() && password == confirmPassword) {
                    registerViewModel.register(email,username, password, phone, address)
                    (activity as MainActivity).showFragment(LoginFragment())
                    Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
