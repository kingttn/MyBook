package com.haunp.mybookstore.presenters.fragment.user.home

import androidx.lifecycle.ViewModel
import com.haunp.mybookstore.domain.usecase.AdminUseCase

class HomeViewModel(private val bookUseCase: AdminUseCase) : ViewModel() {
    val books = bookUseCase.getAllBooks()

}