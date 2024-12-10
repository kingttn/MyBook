package com.haunp.mybookstore.domain.repository

import com.haunp.mybookstore.domain.entity.CartEntity
import com.haunp.mybookstore.domain.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    fun getAllUser(): Flow<List<UserEntity>>
    suspend fun registerUser(userEntity: UserEntity): Long
    suspend fun loginUser(userName: String, password: String): UserEntity
    suspend fun isUserValid(username: String, password: String): Boolean
//    suspend fun addBookInCart(cartEntity: CartEntity)
//    suspend fun deleteBookInCart(cartEntity: CartEntity)
//    suspend fun updateQuantityBook(userId: Int, productId: Int, quantity: Int)
}