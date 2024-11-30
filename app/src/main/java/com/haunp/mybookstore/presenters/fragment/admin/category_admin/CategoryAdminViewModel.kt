package com.haunp.mybookstore.presenters.fragment.admin.category_admin

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.repository.IAdminRepository
import com.haunp.mybookstore.domain.usecase.AdminUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CategoryAdminViewModel(private val bookUseCase: AdminUseCase, private val adminRepository: IAdminRepository) : ViewModel() {

    val categories : LiveData<List<CategoryEntity>> = bookUseCase.getAllCategories()
    fun addCategory(categoryEntity: CategoryEntity): Job {
        return viewModelScope.launch {
            bookUseCase.invoke(categoryEntity)
        }
    }
//    fun addCategory(name: String, imageUri: Uri?) {
//        val newCategory = imageUri?.toString()?.let {
//            CategoryEntity(
//                name = name,
//                imageUri = it
//            )
//        }
//        val currentList = _categories.value ?: mutableListOf()
//        newCategory?.let { currentList.add(it) }
//        _categories.value = currentList
//    }
//    suspend fun deleteCategory(id: Int) {
//        adminRepository.deleteCategory(id)
//    }
    suspend fun updateCategory(categoryEntity: CategoryEntity) {
        adminRepository.updateCategory(categoryEntity)
    }
}