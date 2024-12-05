package com.haunp.mybookstore.presenters.fragment.admin.category_admin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.haunp.mybookstore.databinding.CategoryAdminFragmentBinding
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.presenters.base.BaseFragment
import org.koin.android.ext.android.inject

class CategoryAdminFragment : BaseFragment<CategoryAdminFragmentBinding>() {
    private var selectedImageUri: Uri? = null
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
            saveCategoriesToSharedPreferences(categoryList)
        }
        binding{
            btnSelectImage.setOnClickListener {
                val intent = Intent(Intent.ACTION_PICK).apply { type = "image/*" }
                imagePickerLauncher.launch(intent)
            }
            btnAdd.setOnClickListener {
                val name = edtNameCate.text.toString().trim()
                val imageUriString = selectedImageUri?.toString() ?: ""
                if (name.isNotEmpty()) {
                    val categoryEntity = CategoryEntity(name = name, imageUri = imageUriString)
                    viewModel.addCategory(categoryEntity)
                    edtNameCate.text.clear() // Xóa dữ liệu sau khi thêm
                } else {
                    Toast.makeText(context, "Vui lòng nhập tên danh mục!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private val imagePickerLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            selectedImageUri = result.data?.data
        }
    }
    private fun saveCategoriesToSharedPreferences(categoryList: List<CategoryEntity>) {
        val sharedPreferences = requireContext().getSharedPreferences("CateAppPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()


        // Chuyển danh sách thành JSON
        val gson = Gson()
        val json = gson.toJson(categoryList)

        // Lưu JSON vào SharedPreferences
        editor.putString("cate_list", json)
        editor.apply()
    }
}