package com.haunp.mybookstore.domain.repository

import com.haunp.mybookstore.data.database.dao.CartDao
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CartEntity

interface ICartRepository {
    suspend fun getCart(userId: Int): CartEntity?
    suspend fun addToCart(userId: Int, book: BookEntity)
    suspend fun clearCart(userId: Int)
}