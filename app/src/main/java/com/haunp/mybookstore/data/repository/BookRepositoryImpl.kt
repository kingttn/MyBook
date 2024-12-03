package com.haunp.mybookstore.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.haunp.mybookstore.data.database.dao.BookDao
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.repository.IBookRepository
import kotlinx.coroutines.flow.Flow

class BookRepositoryImpl(private var bookDao: BookDao) : IBookRepository {
    override suspend fun getBooks(): Flow<List<BookEntity>> {
        return bookDao.getAllBooks()
    }
}