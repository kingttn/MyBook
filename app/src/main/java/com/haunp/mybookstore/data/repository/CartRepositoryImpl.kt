package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.database.dao.CartDao
import com.haunp.mybookstore.data.database.dao.UserDao
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CartEntity
import com.haunp.mybookstore.domain.repository.ICartRepository

class CartRepositoryImpl(private val cartDao: CartDao)
    : ICartRepository {
    override suspend fun getCart(userId: Int): CartEntity? {
        return cartDao.getCart(userId)
    }

    override suspend fun addToCart(userId: Int, book: BookEntity) {
//        return cartDao.upsertCart(updatedCart)
    }

    override suspend fun clearCart(userId: Int) {
        TODO("Not yet implemented")
    }
}