package com.haunp.mybookstore.presenters.fragment.admin.book

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.repository.IAdminRepository
<<<<<<< Updated upstream
import com.haunp.mybookstore.domain.usecase.AdminUseCase
import com.haunp.mybookstore.domain.usecase.GetListBookUseCase
import kotlinx.coroutines.launch

class BookViewModel(private val bookUseCase: AdminUseCase, private var getListBookUseCase: GetListBookUseCase) : ViewModel() {


    val books : LiveData<List<BookEntity>> = liveData {
        emitSource(getListBookUseCase().asLiveData())
    }

=======
import com.haunp.mybookstore.domain.usecase.AddBookUseCase
import com.haunp.mybookstore.domain.usecase.GetBookUseCase
import kotlinx.coroutines.launch

class BookViewModel(private val bookUseCase: GetBookUseCase, private val addBookUseCase: AddBookUseCase) : ViewModel() {
    val books: LiveData<List<BookEntity>> = bookUseCase.invoke()
>>>>>>> Stashed changes
    fun addBook(book: BookEntity) {
        viewModelScope.launch {
            addBookUseCase.invoke(book)
        }
    }
<<<<<<< Updated upstream
    fun updateBook(book: BookEntity) {
        viewModelScope.launch {
//            adminRepository.updateBook(book)
        }
    }
//    fun deleteBook(id: Int) {
//        viewModelScope.launch {
//            adminRepository.deleteBook(id)
//        }
//    }
=======
>>>>>>> Stashed changes
}