package com.haunp.mybookstore.domain.repository

import com.haunp.mybookstore.data.database.dao.CartDao
import com.haunp.mybookstore.domain.entity.CartEntity

interface ICartRepository {
    fun addBookToCart(cart:CartEntity)
    fun getCartByUserId(userId: Int): List<CartEntity>
    suspend fun removeBookFromCart(cart: CartEntity)
    suspend fun clearCart(userId: Int)
    suspend fun deleteCartItemById(cartId: Int)
}