package com.haunp.mybookstore.data.repository


import com.haunp.mybookstore.data.database.dao.BookDao
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.repository.IBookRepository
import kotlinx.coroutines.flow.Flow

class BookRepositoryImpl(private var bookDao: BookDao) : IBookRepository {
    override suspend fun getBooks(): Flow<List<BookEntity>> {
        return bookDao.getAllBooks()
    }
    // Kết quả trả về sẽ là một kiểu trạng thái
    override suspend fun addBook(book: BookEntity) {
           return bookDao.insertBook(book)
    }

    override suspend fun updateBook(book: BookEntity) {
        return bookDao.updateBook(book)
    }

    override suspend fun deleteBook(id: Int) {
        return bookDao.deleteBookById(id)
    }

    override suspend fun getBookById(id: Int): BookEntity {
        return bookDao.getBookById(id)!!
    }
}
