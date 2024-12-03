package com.haunp.mybookstore.domain.usecase

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.repository.ICategoryRepository
import kotlinx.coroutines.flow.Flow

class GetCateUseCase(private val categoryRepository: ICategoryRepository) {
    operator fun invoke(): Flow<List<CategoryEntity>> {
        return categoryRepository.getAllCategory()
    }
}