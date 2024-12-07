package com.haunp.mybookstore.domain.usecase

import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.domain.repository.IUserRepository

class LoginUseCase(private val repository: IUserRepository) {
    suspend operator fun invoke(username: String, password: String): UserEntity {
        return repository.loginUser(username, password)
    }
}