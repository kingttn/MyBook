package com.haunp.mybookstore.domain.repository

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.entity.OrderEntity
import com.haunp.mybookstore.domain.entity.UserEntity

interface IAdminRepository {
<<<<<<< Updated upstream
    suspend fun addBook(bookEntity: BookEntity)
//    suspend fun deleteBook(id: Int)
    suspend fun updateBook(bookEntity: BookEntity)
    fun getAllCategory(): LiveData<List<CategoryEntity>>
    suspend fun addCategory(categoryEntity: CategoryEntity)
//    suspend fun deleteCategory(id: Int)
    suspend fun updateCategory(categoryEntity: CategoryEntity)
=======

>>>>>>> Stashed changes
    suspend fun updateOrder(orderEntity: OrderEntity)
    suspend fun addUser(UserEntity: UserEntity):Long
//    suspend fun deleteUser(id: Int)
    suspend fun updateUser(UserEntity: UserEntity)
}