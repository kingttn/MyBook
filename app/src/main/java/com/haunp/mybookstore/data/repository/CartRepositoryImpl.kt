package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.database.dao.CartDao
import com.haunp.mybookstore.data.database.dao.UserDao
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CartEntity
import com.haunp.mybookstore.domain.repository.ICartRepository

class CartRepositoryImpl(private val cartDao: CartDao)
    : ICartRepository {
    override fun addBookToCart(cart: CartEntity) {
        return cartDao.addBookToCart(cart)
    }

    override fun getCartByUserId(userId: Int): List<CartEntity> {
        return cartDao.getCartByUserId(userId)
    }

    override suspend fun removeBookFromCart(cart: CartEntity) {
        return cartDao.removeBookFromCart(cart)
    }

    override suspend fun clearCart(userId: Int) {
        return cartDao.clearCart(userId)
    }

    override suspend fun deleteCartItemById(cartId: Int) {
        return cartDao.deleteCartItemById(cartId)
    }
}