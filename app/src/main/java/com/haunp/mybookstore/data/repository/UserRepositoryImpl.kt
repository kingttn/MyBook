package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.database.dao.CartDao
import com.haunp.mybookstore.data.database.dao.UserDao
import com.haunp.mybookstore.domain.entity.CartEntity
import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(private val userDao: UserDao,private val cartDao: CartDao)
    : IUserRepository {
    override fun getAllUser(): Flow<List<UserEntity>> {
        return userDao.getAllUsers()
    }

    override suspend fun registerUser(userEntity: UserEntity): Long {
        return userDao.insertUser(userEntity)
    }

    override suspend fun loginUser(userName: String, password: String): UserEntity {
        return userDao.login(userName, password) ?: UserEntity()
    }

    override suspend fun isUserValid(username: String, password: String): Boolean {
        return userDao.isUserValid(username, password)
    }
//    override suspend fun addBookInCart(cartEntity: CartEntity) {
//        return cartDao.addToCart(cartEntity)
//    }
//    override suspend fun deleteBookInCart(cartEntity: CartEntity) {
//        return cartDao.removeFromCart(cartEntity)
//    }
//    override suspend fun updateQuantityBook(userId: Int, productId: Int, quantity: Int) {
//        return cartDao.updateCartQuantity(userId, productId, quantity)
//    }
}