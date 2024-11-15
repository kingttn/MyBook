package com.haunp.mybookstore.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.haunp.mybookstore.data.model.entity.RateBook

@Dao
interface CommentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(rateBook: RateBook)

    @Update
    suspend fun updateComment(rateBook: RateBook)

    @Delete()
    suspend fun deleteComment(rateBook: RateBook)

    @Query("SELECT * FROM comments WHERE bookId = :productId")
    suspend fun getCommentsByProductId(productId: Int): List<RateBook>
}