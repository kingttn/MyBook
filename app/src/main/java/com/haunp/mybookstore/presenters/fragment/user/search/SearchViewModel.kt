package com.haunp.mybookstore.presenters.fragment.user.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.usecase.GetListBookUseCase

class SearchViewModel (private val getListBookUseCase: GetListBookUseCase) : ViewModel() {
    val books: LiveData<List<BookEntity>> = liveData {
        emitSource(getListBookUseCase().asLiveData())
    }
}