package com.haunp.mybookstore.presenters.fragment.user.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.haunp.mybookstore.R
import com.haunp.mybookstore.databinding.HomeFragmentBinding
import com.haunp.mybookstore.presenters.base.BaseFragment
import org.koin.android.ext.android.inject


class HomeFragment : BaseFragment<HomeFragmentBinding>() {
    private val imageList = listOf(
        R.drawable.anh1, // Thay bằng tên ảnh trong drawable
        R.drawable.bookapplogo,
        R.drawable.mybook
    )
    private var currentIndex = 0
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var bannerImageView: ImageView

    private val slideshowRunnable = object : Runnable {
        override fun run() {
            bannerImageView.setImageResource(imageList[currentIndex])
            currentIndex = (currentIndex + 1) % imageList.size
            handler.postDelayed(this, 3000) // Thời gian chuyển ảnh (3 giây)
        }
    }
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
        bannerImageView = binding.bannerImageView
        handler.post(slideshowRunnable)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(slideshowRunnable)
    }
}