package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.database.dao.CartDao
import com.haunp.mybookstore.data.database.dao.UserDao
import com.haunp.mybookstore.domain.entity.CartEntity
import com.haunp.mybookstore.domain.repository.ICartRepository

class CartRepositoryImpl(private val cartDao: CartDao, private val userDao: UserDao)
    : ICartRepository {
    override suspend fun getAllCart(userId: Int): List<CartEntity> {
        return cartDao.getCartByUserId(userId)
    }
}