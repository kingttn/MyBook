package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.database.dao.UserDao
import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.domain.repository.IUserRepository

class UserRepositoryImpl(private val userDao: UserDao) : IUserRepository {
    override suspend fun registerUser(userEntity: UserEntity): Long {
        return userDao.insertUser(userEntity)
    }

    override suspend fun loginUser(userName: String, password: String): UserEntity {
        return userDao.login(userName, password) ?: UserEntity()
    }


}