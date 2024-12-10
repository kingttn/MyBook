package com.haunp.mybookstore.domain.usecase

import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.repository.IBookRepository

class UpdateBookUseCase(private val repository: IBookRepository) {

    // Hàm này sẽ gọi phương thức updateBook của repository
    suspend operator fun invoke(book: BookEntity) {
        repository.updateBook(book)
    }
}