package com.haunp.mybookstore.presenters.fragment.user.category_user

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.haunp.mybookstore.databinding.CategoryUserFragmentBinding
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.presenters.base.BaseFragment
import com.haunp.mybookstore.presenters.fragment.admin.category_admin.CategoryAdapter
import org.koin.android.ext.android.inject

class CategoryUserFragment : BaseFragment<CategoryUserFragmentBinding>() {
    private val viewModel: CategoryUserViewModel by inject()
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): CategoryUserFragmentBinding {
        return CategoryUserFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val adapter = CategoryAdapter()
        binding.categoryRecyclerView.adapter = adapter
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(context)

        // Lắng nghe LiveData và cập nhật RecyclerView
        val categoryList = getCategoriesFromSharedPreferences()
        Log.e("hau.np", "initView: $categoryList")
        adapter.submitList(categoryList)
    }

    private fun getCategoriesFromSharedPreferences(): List<CategoryEntity> {
        val sharedPreferences = requireContext().getSharedPreferences("CateAppPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("cate_list", null)

        // Nếu không có dữ liệu, trả về danh sách rỗng
        return if (json != null) {
            val type = object : TypeToken<List<CategoryEntity>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }
}