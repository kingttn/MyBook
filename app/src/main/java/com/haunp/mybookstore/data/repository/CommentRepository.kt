package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.local.dao.CommentDao
import com.haunp.mybookstore.data.model.entity.RateBook

class CommentRepository(private val commentDao: CommentDao){
    suspend fun insertComment(rateBook: RateBook) {
        return commentDao.insertComment(rateBook)
    }

    suspend fun getCommentsByBookId(bookId: Int): List<RateBook> {
        return commentDao.getCommentsByProductId(bookId)
    }

    suspend fun updateComment(rateBook: RateBook) {
        return commentDao.updateComment(rateBook)
    }

    suspend fun deleteComment(rateBook: RateBook) {
        return commentDao.deleteComment(rateBook)
    }
}