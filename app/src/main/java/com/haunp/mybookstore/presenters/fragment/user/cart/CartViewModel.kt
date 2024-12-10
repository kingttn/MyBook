package com.haunp.mybookstore.presenters.fragment.user.cart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.haunp.mybookstore.domain.entity.BookEntity

class CartViewModel():ViewModel(){
    private val _cartItems = MutableLiveData<MutableList<Int>>(mutableListOf())
    val cartItems: LiveData<MutableList<Int>> get() = _cartItems

    private val _allBooks = MutableLiveData<List<BookEntity>>() // Lưu danh sách sách
    val allBooks: LiveData<List<BookEntity>> get() = _allBooks

    fun setAllBooks(books: List<BookEntity?>) {
        _allBooks.value = books?.filterNotNull() ?: emptyList()
        Log.d("hau.np", "setAllBooks: ${_allBooks.value}")
    }

    fun addToCart(bookId: Int) {
        _cartItems.value?.apply {
            if (!contains(bookId)) { // Chỉ thêm nếu chưa có trong giỏ hàng
                add(bookId)
                _cartItems.value = this
                Log.d("hau.np", "Cart updated: $this")
//                _cartItems.postValue(this)
//                Log.d("hau.np", "addToCart: $this")
            }
        }
    }
}
