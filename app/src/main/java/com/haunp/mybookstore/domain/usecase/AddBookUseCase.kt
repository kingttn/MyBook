package com.haunp.mybookstore.domain.usecase

import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.repository.IBookRepository

class AddBookUseCase(private val bookRepo: IBookRepository) {
    suspend operator fun invoke(book: BookEntity) {
        return bookRepo.addBook(book)
    }
}