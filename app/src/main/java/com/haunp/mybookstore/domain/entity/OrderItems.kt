package com.haunp.mybookstore.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "order_items",
    primaryKeys = ["orderId", "productId"],
    foreignKeys = [
        ForeignKey(
            entity = OrderEntity::class,
            parentColumns = ["orderId"],
            childColumns = ["orderId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BookEntity::class,
            parentColumns = ["productId"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class OrderItem(
    val orderId: Int,
    val productId: Int,
    val quantity: Int,
    val price: Double
)
