package com.haunp.mybookstore.data.repository

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.data.database.dao.CategoryDao
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.repository.ICategoryRepository

class CategoryRepositoryImpl(private var categoryDao: CategoryDao): ICategoryRepository {

    override fun getAllCategory(): LiveData<List<CategoryEntity>> {
        return categoryDao.getAllCategory()
    }

    override suspend fun addCategory(categoryEntity: CategoryEntity) {
        return categoryDao.insertCategory(categoryEntity)
    }

    override suspend fun deleteCategory(id: Int) {
        return categoryDao.deleteCategory(id)
    }

    override suspend fun updateCategory(categoryEntity: CategoryEntity) {
        return categoryDao.updateCategory(categoryEntity)
    }
}