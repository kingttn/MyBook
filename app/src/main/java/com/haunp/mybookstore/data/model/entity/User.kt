package com.haunp.mybookstore.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val email: String,
    val username: String,
    val phone:String,
    val address:String,
    val password: String,
    val role: Boolean // 0 : Admin or 1: User
)