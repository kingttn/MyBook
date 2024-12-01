package com.haunp.mybookstore.presenters.fragment.user.home

import android.os.Bundle
import android.view.View
import com.haunp.mybookstore.databinding.HomeFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment
import org.koin.android.ext.android.inject


class HomeFragment : BaseFragment<HomeFragmentBinding>() {
    override var isTerminalBackKeyActive: Boolean = true
    private val viewModel: HomeViewModel by inject()

    override fun getDataBinding(): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(layoutInflater)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        val adapter = HomeAdapter()
        binding.homeRecyclerView.adapter = adapter
        viewModel.books.observe(viewLifecycleOwner) { bookList ->
            adapter.submitList(bookList)
        }
    }
}