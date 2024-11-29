package com.haunp.mybookstore.presenters.fragment.admin.category_admin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.repository.IAdminRepository
import com.haunp.mybookstore.domain.usecase.AdminUseCase
import kotlinx.coroutines.launch

class CategoryAdminViewModel(private val bookUseCase: AdminUseCase, private val adminRepository: IAdminRepository) : ViewModel() {

    val categories: LiveData<List<CategoryEntity>> = bookUseCase.getAllCategory()


    fun addCategory(category : CategoryEntity) {
        viewModelScope.launch {
            bookUseCase.invoke(category)
        }
    }
//    suspend fun deleteCategory(id: Int) {
//        adminRepository.deleteCategory(id)
//    }
    suspend fun updateCategory(categoryEntity: CategoryEntity) {
        adminRepository.updateCategory(categoryEntity)
    }


}