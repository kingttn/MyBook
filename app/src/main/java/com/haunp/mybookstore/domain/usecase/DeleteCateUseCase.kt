package com.haunp.mybookstore.domain.usecase

import com.haunp.mybookstore.domain.repository.ICategoryRepository

class DeleteCateUseCase(private val categoryRepo: ICategoryRepository) {
    suspend operator fun invoke(categoryId: Int) {
        return categoryRepo.deleteCategory(categoryId)
    }
}