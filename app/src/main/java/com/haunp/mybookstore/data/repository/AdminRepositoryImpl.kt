package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.database.dao.BookDao
import com.haunp.mybookstore.data.database.dao.CategoryDao
import com.haunp.mybookstore.data.database.dao.OrderDao
import com.haunp.mybookstore.data.database.dao.UserDao
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.entity.OrderEntity
import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.domain.repository.IAdminRepository

class AdminRepositoryImpl(
    private val userDao: UserDao,
    private val categoryDao: CategoryDao,
    private val bookDao: BookDao,
    private val orderDao: OrderDao
) : IAdminRepository {
    override suspend fun addBook(bookEntity: BookEntity) {
        return bookDao.insertBook(bookEntity)
    }

//    override suspend fun deleteBook(id: Int) {
//        return bookDao.deleteBookById(id)
//    }

    override suspend fun updateBook(bookEntity: BookEntity) {
        return bookDao.updateBook(bookEntity)
    }

    override suspend fun addCategory(categoryEntity: CategoryEntity) {
        return categoryDao.insertCategory(categoryEntity)
    }

//    override suspend fun deleteCategory(id: Int) {
//        return categoryDao.deleteCategory(id)
//    }

    override suspend fun updateCategory(categoryEntity: CategoryEntity) {
        return categoryDao.updateCategory(categoryEntity)
    }

    override suspend fun updateOrder(orderEntity: OrderEntity) {
        return orderDao.updateOrder(orderEntity)
    }

    override suspend fun addUser(UserEntity: UserEntity): Long {
        return userDao.insertUser(UserEntity)
    }

//    override suspend fun deleteUser(id: Int) {
//        return userDao.deleteUserById(id)
//    }

    override suspend fun updateUser(UserEntity: UserEntity) {
        return userDao.updateUser(UserEntity)
    }
}