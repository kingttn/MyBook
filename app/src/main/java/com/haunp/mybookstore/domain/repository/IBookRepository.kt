package com.haunp.mybookstore.domain.repository

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.domain.entity.BookEntity
<<<<<<< Updated upstream
import kotlinx.coroutines.flow.Flow

interface IBookRepository {
    suspend fun getBooks() : Flow<List<BookEntity>>
=======

interface IBookRepository {
    fun getAllBooks(): LiveData<List<BookEntity>>
    suspend fun addBook(bookEntity: BookEntity)
    suspend fun deleteBook(id: Int)
    suspend fun updateBook(bookEntity: BookEntity)
>>>>>>> Stashed changes
}