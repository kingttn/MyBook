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
    @Insert
    fun addBookToCart(cart: CartEntity)

    @Query("SELECT * FROM carts WHERE userid = :userId")
    fun getCartByUserId(userId: Int): List<CartEntity>

    @Delete
    suspend fun removeBookFromCart(cart: CartEntity)

    @Query("DELETE FROM carts WHERE userid = :userId")
    suspend fun clearCart(userId: Int)

    // Thêm phương thức để xóa cart item khi quantity = 0
    @Query("DELETE FROM carts WHERE cartId = :cartId")
    suspend fun deleteCartItemById(cartId: Int)

}
