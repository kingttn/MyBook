package com.haunp.mybookstore.presenters.fragment.admin.category_admin

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.usecase.AddCateUseCase
import com.haunp.mybookstore.domain.usecase.DeleteCateUseCase
import com.haunp.mybookstore.domain.usecase.GetCateUseCase

import kotlinx.coroutines.launch

class CategoryAdminViewModel(private var getCateUseCase : GetCateUseCase, private var addCateUseCase : AddCateUseCase,private var deleteCateUseCase : DeleteCateUseCase) : ViewModel() {

    val categories : LiveData<List<CategoryEntity>> = liveData {
        emitSource(getCateUseCase().asLiveData())
    }

    fun addCategory(categoryEntity: CategoryEntity){
        viewModelScope.launch {
            addCateUseCase.invoke(categoryEntity)
        }
    }
    suspend fun deleteCategory(categoryId: Int) {
        viewModelScope.launch {
            deleteCateUseCase.invoke(categoryId)
        }
    }
}