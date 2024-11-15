package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.local.dao.CategoryDao
import com.haunp.mybookstore.data.model.entity.Category

class CategoryRepository (private val categoryDao: CategoryDao){
    suspend fun insertCategory(category: Category) {
        return categoryDao.insertCategory(category)
    }

    suspend fun updateCategory(category: Category) {
        return categoryDao.updateCategory(category)
    }

    suspend fun deleteCategory(category: Category) {
        return categoryDao.deleteCategory(category)
    }

    suspend fun getAllCategories(): List<Category> {
        return categoryDao.getAllCategory()
    }
}