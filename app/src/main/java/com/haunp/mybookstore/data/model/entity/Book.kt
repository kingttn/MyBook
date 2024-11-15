package com.haunp.mybookstore.data.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "books",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Book(
    @PrimaryKey(autoGenerate = true) val bookId: Int = 0,
    val title: String,
    val author: String,
    val price: Double,
    val quantity: Int,
    val categoryId: Int, // Khóa ngoại đến bảng Categories
    val size: String // Kích thước (nếu có)
)