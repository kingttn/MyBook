package com.haunp.mybookstore.data.repository

import androidx.lifecycle.LiveData
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
    private val orderDao: OrderDao
) : IAdminRepository {
<<<<<<< Updated upstream

    override suspend fun addBook(bookEntity: BookEntity) {
        return bookDao.insertBook(bookEntity)
    }

//    override suspend fun deleteBook(id: Int) {
//        return bookDao.deleteBookById(id)
//    }

    override suspend fun updateBook(bookEntity: BookEntity) {
        return bookDao.updateBook(bookEntity)
    }
    override fun getAllCategory(): LiveData<List<CategoryEntity>> {
        return categoryDao.getAllCategory()
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

=======
>>>>>>> Stashed changes
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