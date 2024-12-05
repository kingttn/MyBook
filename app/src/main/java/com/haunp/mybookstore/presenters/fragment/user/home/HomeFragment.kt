package com.haunp.mybookstore.presenters.fragment.user.home

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.haunp.mybookstore.R
import com.haunp.mybookstore.databinding.HomeFragmentBinding
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.presenters.base.BaseFragment
import org.koin.android.ext.android.inject


class HomeFragment : BaseFragment<HomeFragmentBinding>() {

    // Danh sách hình ảnh cho banner
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

    // Khởi tạo ViewModel
    override var isTerminalBackKeyActive: Boolean = true
    private val viewModel: HomeViewModel by inject()

    override fun getDataBinding(): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupObservers()
    }

    override fun initView() {
        // Thiết lập adapter cho RecyclerView
        val adapter = HomeAdapter()
        binding.homeRecyclerView.adapter = adapter
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(context)
        // Lấy dữ liệu từ SharedPreferences và cập nhật adapter
        val bookList = getBooksFromSharedPreferences()
        adapter.submitList(bookList)
        // Khởi động banner slideshow
        bannerImageView = binding.bannerImageView
        handler.post(slideshowRunnable)
    }

//    private fun setupObservers() {
//        // Lắng nghe LiveData từ ViewModel nếu cần đồng bộ thêm dữ liệu
//        viewModel.books.observe(viewLifecycleOwner) { books ->
//            saveBooksToSharedPreferences(books)
//            val adapter = binding.homeRecyclerView.adapter as? HomeAdapter
//            adapter?.submitList(books)
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(slideshowRunnable)
    }

    private fun getBooksFromSharedPreferences(): List<BookEntity> {
        val sharedPreferences = requireContext().getSharedPreferences("BookAppPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("book_list", null)

        // Nếu không có dữ liệu, trả về danh sách rỗng
        return if (json != null) {
            val type = object : TypeToken<List<BookEntity>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }
}
