package com.haunp.mybookstore.domain.usecase

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.repository.ICategoryRepository

class GetCateUseCase(private val categoryRepository: ICategoryRepository) {
    operator fun invoke(): LiveData<List<CategoryEntity>> {
        return categoryRepository.getAllCategory()
    }
}