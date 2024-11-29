package com.haunp.mybookstore.domain.usecase

import androidx.lifecycle.LiveData
import com.haunp.mybookstore.domain.entity.BookEntity
import com.haunp.mybookstore.domain.entity.CategoryEntity
import com.haunp.mybookstore.domain.repository.IAdminRepository

class AdminUseCase (private val repository: IAdminRepository) {
    fun getAllBooks(): LiveData<List<BookEntity>> {
        return repository.getAllBooks()
    }
    fun getAllCategory(): LiveData<List<CategoryEntity>> {
        return repository.getAllCategory()
    }
    suspend operator fun invoke(book: BookEntity) {
        return repository.addBook(book)
    }
    suspend operator fun invoke(category: CategoryEntity) {
        return repository.addCategory(category)
    }

}