package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.local.dao.BookDao
import com.haunp.mybookstore.data.local.dao.CategoryDao
import com.haunp.mybookstore.data.local.dao.OrderDao
import com.haunp.mybookstore.data.local.dao.UserDao
import com.haunp.mybookstore.data.model.entity.Book
import com.haunp.mybookstore.data.model.entity.Category
import com.haunp.mybookstore.data.model.entity.Order
import com.haunp.mybookstore.data.model.entity.User

class AdminRepository(private val userDao: UserDao
                      , private val bookDao: BookDao, private val orderDao: OrderDao, private val categoryDao: CategoryDao
){
    suspend fun insertBook(book: Book) {
        bookDao.insertBook(book)
    }

    suspend fun updateBook(book: Book) {
        bookDao.updateBook(book)
    }

    suspend fun deleteBook(book: Book) {
        bookDao.deleteBook(book)
    }

    suspend fun insertCategory(category: Category){
        categoryDao.insertCategory(category)
    }

    suspend fun updateCategory(category: Category) {
        categoryDao.updateCategory(category)
    }

    suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }

    suspend fun getAllOrders(): List<Order> {
        return orderDao.getAllOrders()
    }

    suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }

    suspend fun insert(user: User) {
        userDao.insertUser(user)
    }

    suspend fun update(user: User) {
        userDao.updateUser(user)
    }

    suspend fun delete(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

}