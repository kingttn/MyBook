package com.haunp.mybookstore.presenters.fragment.user.category_user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.usecase.GetCateUseCase

class CategoryUserViewModel(private var getCateUseCase:GetCateUseCase) : ViewModel() {
    val categories : LiveData<List<CategoryEntity>> = liveData {
        emitSource(getCateUseCase().asLiveData())
    }
}