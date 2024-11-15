package com.haunp.mybookstore.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "cart",
    primaryKeys = ["userId", "bookId"],
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BookEntity::class,
            parentColumns = ["bookId"],
            childColumns = ["bookId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CartEntity(
                val userId: Int,
                val bookId: Int,
                val quantity: Int
)
