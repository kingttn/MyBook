package com.haunp.mybookstore.domain.usecase

import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.repository.IBookRepository

class GetBookByIdUseCase(private val repository: IBookRepository) {
    suspend operator fun invoke(bookId: Int): BookEntity? {
        return repository.getBookById(bookId)
    }
}