package com.haunp.mybookstore.domain.repository

import com.haunp.mybookstore.domain.entity.CartEntity

interface ICartRepository {
    suspend fun getAllCart(userId: Int): List<CartEntity>
}