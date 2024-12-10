package com.haunp.mybookstore.presenters.fragment.admin.book

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.usecase.GetListBookUseCase
import com.haunp.mybookstore.domain.usecase.AddBookUseCase
import com.haunp.mybookstore.domain.usecase.DeleteBookUseCase
import com.haunp.mybookstore.domain.usecase.GetBookByIdUseCase
import com.haunp.mybookstore.domain.usecase.UpdateBookUseCase
import kotlinx.coroutines.launch

class BookViewModel(private val getListBookUseCase: GetListBookUseCase,
                    private val addBookUseCase: AddBookUseCase,
                    private val updateBookUseCase: UpdateBookUseCase,
                    private val deleteBookUseCase: DeleteBookUseCase,
                    private val getBookByIdUseCase: GetBookByIdUseCase) : ViewModel() {
    val books : LiveData<List<BookEntity>> = liveData {
        emitSource(getListBookUseCase().asLiveData())
    }

    fun addBook(book: BookEntity) {
        viewModelScope.launch {
            val result = addBookUseCase.invoke(book)
            addBookUseCase.invoke(book)
        }
    }

     //Chỉnh sửa sách
    fun updateBook(book: BookEntity) {
        viewModelScope.launch {
            updateBookUseCase.invoke(book)
        }
    }

    // Xóa sách theo ID
    fun deleteBook(bookId: Int) {
        viewModelScope.launch {
            deleteBookUseCase.invoke(bookId)
        }
    }

}