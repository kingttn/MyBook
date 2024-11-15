package com.haunp.mybookstore.view.fragment.User.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.haunp.mybookstore.R
import com.haunp.mybookstore.databinding.CategoryFragmentBinding
import com.haunp.mybookstore.view.base.BaseFragment

class CategoryFragment : BaseFragment<CategoryFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): CategoryFragmentBinding {
        return CategoryFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
    }


}