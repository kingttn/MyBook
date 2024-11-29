package com.haunp.mybookstore.presenters.fragment.admin.category_admin

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.haunp.mybookstore.databinding.CategoryAdminFragmentBinding
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.presenters.base.BaseFragment
import org.koin.android.ext.android.inject

class CategoryAdminFragment : BaseFragment<CategoryAdminFragmentBinding>() {
    private val viewModel: CategoryAdminViewModel by inject()
    override var isTerminalBackKeyActive: Boolean = true

    override fun getDataBinding(): CategoryAdminFragmentBinding {
        return CategoryAdminFragmentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val adapter = CategoryAdapter()
        binding.categoryAdminRecyclerView.adapter = adapter
        binding.categoryAdminRecyclerView.layoutManager = LinearLayoutManager(context)

        // Lắng nghe LiveData và cập nhật RecyclerView
        viewModel.categories.observe(viewLifecycleOwner) { categoryList ->
            adapter.submitList(categoryList)
        }
        binding{
            ftbAdd.setOnClickListener {
                val name = edtName.text.toString().trim()
                if (name.isNotEmpty()) {
                    val categoryEntity = CategoryEntity(name = name)
                    viewModel.addCategory(categoryEntity)
                    edtName.text.clear() // Xóa dữ liệu sau khi thêm
                } else {
                    Toast.makeText(context, "Vui lòng nhập tên danh mục!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}