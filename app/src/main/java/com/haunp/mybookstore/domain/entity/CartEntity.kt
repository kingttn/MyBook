package com.haunp.mybookstore.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "carts",
    primaryKeys = ["userId", "bookId"],
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CartEntity(
                val userId: Int,
                val bookId: String,
                val totalPrice: Double
)
