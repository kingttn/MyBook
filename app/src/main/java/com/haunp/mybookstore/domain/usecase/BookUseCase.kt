package com.haunp.mybookstore.domain.usecase

import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.domain.repository.IAdminRepository

class BookUseCase (private val repository: IAdminRepository) {
    suspend operator fun invoke(book: BookEntity) {
        return repository.addBook(book)
    }
}