package com.haunp.mybookstore.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.haunp.mybookstore.domain.entity.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: BookEntity)

    @Update
    suspend fun updateBook(book: BookEntity)

    @Query("DELETE FROM books WHERE bookId = :bookId")
    suspend fun deleteBookById(bookId: Int)

    @Query("SELECT * FROM books WHERE title LIKE :keyword OR author LIKE :keyword")
    suspend fun searchBooks(keyword: String): List<BookEntity>

//    @Query("SELECT * FROM books WHERE categoryId = :categoryId")
//    suspend fun getBooksByCategory(categoryId: Int): List<BookEntity>

    // Loại bỏ suspend và để Room tự động chuyển đổi thành LiveData
    @Query("SELECT * FROM books")
    fun getAllBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM books WHERE bookId = :bookId")
    suspend fun getBookById(bookId: Int): BookEntity?
}
