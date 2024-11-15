package com.haunp.mybookstore.data.repository

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.data.local.dao.BookDao
import com.haunp.mybookstore.data.model.entity.Book

class BookRepository(private val bookDao: BookDao
){
    suspend fun getAllBooks(): LiveData<List<Book>> {
        return bookDao.getAllBooks()
    }

    suspend fun getBookById(bookId: Int): Book? {
        return bookDao.getBookById(bookId)
    }

    suspend fun searchBooks(query: String): List<Book> {
        return bookDao.searchBooks("%$query%")
    }

    suspend fun getBooksByCategory(categoryId: Int): List<Book> {
        return bookDao.getBooksByCategory(categoryId)
    }

    suspend fun insertBook(book: Book) {
        return bookDao.insertBook(book)
    }

    suspend fun deleteBook(book: Book) {
        return bookDao.deleteBook(book)
    }

    suspend fun updateBook(book: Book) {
        return bookDao.updateBook(book)
    }
}