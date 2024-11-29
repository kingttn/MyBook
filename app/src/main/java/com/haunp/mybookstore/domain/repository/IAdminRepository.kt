package com.haunp.mybookstore.domain.repository

import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.entity.OrderEntity
import com.haunp.mybookstore.domain.entity.UserEntity

interface IAdminRepository {
    suspend fun addBook(bookEntity: BookEntity)
//    suspend fun deleteBook(id: Int)
    suspend fun updateBook(bookEntity: BookEntity)
    suspend fun addCategory(categoryEntity: CategoryEntity)
//    suspend fun deleteCategory(id: Int)
    suspend fun updateCategory(categoryEntity: CategoryEntity)
    suspend fun updateOrder(orderEntity: OrderEntity)
    suspend fun addUser(UserEntity: UserEntity):Long
//    suspend fun deleteUser(id: Int)
    suspend fun updateUser(UserEntity: UserEntity)
}