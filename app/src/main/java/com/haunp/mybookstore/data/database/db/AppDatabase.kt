package com.haunp.mybookstore.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.haunp.mybookstore.data.database.dao.BookDao
import com.haunp.mybookstore.data.database.dao.CartDao
import com.haunp.mybookstore.data.database.dao.CategoryDao
import com.haunp.mybookstore.data.database.dao.RateDao
import com.haunp.mybookstore.data.database.dao.OrderDao
import com.haunp.mybookstore.data.database.dao.UserDao
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CartEntity
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.entity.OrderEntity
import com.haunp.mybookstore.domain.entity.OrderItem
import com.haunp.mybookstore.domain.entity.RateEntity
import com.haunp.mybookstore.domain.entity.UserEntity

@Database(
    entities = [UserEntity::class, BookEntity::class, CategoryEntity::class,
        CartEntity::class, OrderEntity::class, OrderItem::class, RateEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getBookDao(): BookDao
    abstract fun getCategoriesDao(): CategoryDao
    abstract fun getCartDao(): CartDao
    abstract fun getOrderDao(): OrderDao
    abstract fun getRateDao(): RateDao
}
