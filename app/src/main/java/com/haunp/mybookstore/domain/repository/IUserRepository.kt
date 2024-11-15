package com.haunp.mybookstore.domain.repository

import com.haunp.mybookstore.domain.entity.UserEntity

interface IUserRepository {
    suspend fun registerUser(userEntity: UserEntity): Long
    suspend fun loginUser(userName: String, password: String): UserEntity
}