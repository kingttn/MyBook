package com.haunp.mybookstore.presenters.fragment.admin.user

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.haunp.mybookstore.databinding.UserFragmentBinding
import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.presenters.base.BaseFragment
import org.koin.android.ext.android.inject

class UserFragment : BaseFragment<UserFragmentBinding>(){
    private val viewModel: UserViewModel by inject()
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): UserFragmentBinding{
        return UserFragmentBinding.inflate(layoutInflater)
    }
    override fun initView() {
        val adapter = UserAdapter()
        binding.userRecyclerView.adapter = adapter
        binding.userRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.users.observe(viewLifecycleOwner) { userList ->
            adapter.submitList(userList)
        }
        binding{
            btnAdd.setOnClickListener{
                val name = edtName.text.toString()
                val email = edtEmail.text.toString()
                val password = edtPassword.text.toString()
                val phone = edtPhone.text.toString()
                val address = edtAddress.text.toString()
                val role = edtRole.text.toString()
                val userEntity = UserEntity(
                    username = name,
                    email = email,
                    password = password,
                    phone = phone,
                    address = address,
                    role = role.toInt()
                )
                viewModel.registerUser(userEntity)
                edtName.setText("")
                edtEmail.setText("")
                edtPassword.setText("")
                edtPhone.setText("")
                edtAddress.setText("")
            }
        }

    }

}