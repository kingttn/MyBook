package com.haunp.mybookstore.presenters.fragment.admin.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.domain.repository.IAdminRepository
import com.haunp.mybookstore.domain.usecase.BookUseCase
import kotlinx.coroutines.launch

class BookViewModel(private val bookUseCase: BookUseCase,private val adminRepository: IAdminRepository) : ViewModel() {
    private val _bookResult = MutableLiveData<BookEntity>()

    fun addBook(book: BookEntity) {
        viewModelScope.launch {
            bookUseCase.invoke(book)
        }
    }
    fun updateBook(book: BookEntity) {
        viewModelScope.launch {
            adminRepository.updateBook(book)
        }
    }
//    fun deleteBook(id: Int) {
//        viewModelScope.launch {
//            adminRepository.deleteBook(id)
//        }
//    }
}