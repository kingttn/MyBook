package com.haunp.mybookstore.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haunp.mybookstore.domain.entity.CartEntity

@Dao
interface CartDao {
    // Thêm giỏ hàng mới hoặc cập nhật nếu đã tồn tại
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCart(cart: CartEntity)

    // Lấy giỏ hàng của người dùng
    @Query("SELECT * FROM carts WHERE userId = :userId")
    suspend fun getCart(userId: Int): CartEntity?

    // Xóa giỏ hàng
    @Query("DELETE FROM carts WHERE userId = :userId")
    suspend fun clearCart(userId: Int)


}
