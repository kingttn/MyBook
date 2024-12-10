package com.haunp.mybookstore.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "carts")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
                val cartId: Int,
                val userId: Int,
                val bookId: String,
                val quantity: Int
)
