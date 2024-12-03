package com.haunp.mybookstore.domain.usecase

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.repository.IAdminRepository
import com.haunp.mybookstore.domain.repository.IBookRepository
import com.haunp.mybookstore.domain.repository.ICartRepository
import kotlinx.coroutines.flow.Flow

class GetListBookUseCase(private val repository: IBookRepository) {
    suspend operator fun invoke(): Flow<List<BookEntity>> {
        return repository.getBooks()
    }
}