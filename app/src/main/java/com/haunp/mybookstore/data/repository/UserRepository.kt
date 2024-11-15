package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.local.dao.UserDao
import com.haunp.mybookstore.data.model.entity.User

class UserRepository(private val userDao: UserDao){
    suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }

    suspend fun register(user: User) {
        userDao.insertUser(user)
    }

}