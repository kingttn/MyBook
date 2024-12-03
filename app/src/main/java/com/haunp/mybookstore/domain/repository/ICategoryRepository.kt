package com.haunp.mybookstore.domain.repository

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.domain.entity.CategoryEntity

interface ICategoryRepository {
    fun getAllCategory(): LiveData<List<CategoryEntity>>
    suspend fun addCategory(categoryEntity: CategoryEntity)
    suspend fun deleteCategory(id: Int)
    suspend fun updateCategory(categoryEntity: CategoryEntity)
}