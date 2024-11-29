package com.haunp.mybookstore.presenters.fragment.admin.category_admin

import androidx.lifecycle.ViewModel
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.repository.IAdminRepository

class CategoryAdminViewModel(private val adminRepository: IAdminRepository) : ViewModel() {
    suspend fun addCategory(categoryEntity: CategoryEntity) {
        adminRepository.addCategory(categoryEntity)
    }
//    suspend fun deleteCategory(id: Int) {
//        adminRepository.deleteCategory(id)
//    }
    suspend fun updateCategory(categoryEntity: CategoryEntity) {
        adminRepository.updateCategory(categoryEntity)
    }


}