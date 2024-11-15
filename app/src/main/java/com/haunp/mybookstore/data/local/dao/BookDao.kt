package com.haunp.mybookstore.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.haunp.mybookstore.data.model.entity.Book

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM books WHERE title LIKE :keyword OR author LIKE :keyword")
    suspend fun searchBooks(keyword: String): List<Book>

    @Query("SELECT * FROM books WHERE categoryId = :categoryId")
    suspend fun getBooksByCategory(categoryId: Int): List<Book>

    // Loại bỏ suspend và để Room tự động chuyển đổi thành LiveData
    @Query("SELECT * FROM books")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE bookId = :bookId")
    suspend fun getBookById(bookId: Int): Book?
}
