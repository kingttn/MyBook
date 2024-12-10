package com.haunp.mybookstore.domain.usecase

import com.haunp.mybookstore.domain.repository.IBookRepository

class DeleteBookUseCase(private val repository: IBookRepository) {

    // Hàm này sẽ gọi phương thức deleteBookById của repository
    suspend operator fun invoke(bookId: Int) {
        repository.deleteBook(bookId)
    }
}