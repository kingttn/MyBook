package com.haunp.mybookstore.domain.usecase

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.repository.IBookRepository

class GetBookUseCase(private var bookRepo: IBookRepository) {
    operator fun invoke(): LiveData<List<BookEntity>> {
        return bookRepo.getAllBooks()
    }
}