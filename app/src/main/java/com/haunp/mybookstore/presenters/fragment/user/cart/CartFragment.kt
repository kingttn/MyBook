package com.haunp.mybookstore.presenters.fragment.user.cart

import com.haunp.mybookstore.databinding.CartFragmentBinding
import com.haunp.mybookstore.databinding.CategoryUserFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment
import com.haunp.mybookstore.presenters.fragment.main.MainActivity
import com.haunp.mybookstore.presenters.fragment.user.home.HomeFragment

class CartFragment : BaseFragment<CartFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): CartFragmentBinding {
        return CartFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        binding{
            icCancel.setOnClickListener {
                (activity as MainActivity).showFragment(HomeFragment())
            }
        }
    }
}