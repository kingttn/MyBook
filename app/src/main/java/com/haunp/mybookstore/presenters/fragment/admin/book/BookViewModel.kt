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
import kotlinx.coroutines.launch

class BookViewModel(private val getListBookUseCase: GetListBookUseCase, private val addBookUseCase: AddBookUseCase) : ViewModel() {
    val books : LiveData<List<BookEntity>> = liveData {
        emitSource(getListBookUseCase().asLiveData())
    }
    fun addBook(book: BookEntity) {
        viewModelScope.launch {
            addBookUseCase.invoke(book)
        }
    }
}