package com.haunp.mybookstore.view.fragment.Admin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.haunp.mybookstore.data.model.entity.Book
import com.haunp.mybookstore.data.model.entity.Category
import com.haunp.mybookstore.data.model.entity.Order
import com.haunp.mybookstore.data.model.entity.User
import com.haunp.mybookstore.data.repository.AdminRepository
import com.haunp.mybookstore.data.repository.BookRepository

class AdminViewModel(private val adminRepository: AdminRepository
) : ViewModel() {
    val listBook = MutableLiveData<List<Book>>()
    val listUser = MutableLiveData<List<User>>()
    val listCategory = MutableLiveData<List<Category>>()
    val listOrder = MutableLiveData<List<Order>>()

    suspend fun login(username: String, password: String): User? {
        return adminRepository.login(username, password)
    }
    suspend fun insert(user: User) {
        adminRepository.insert(user)
    }
    suspend fun update(user: User) {
        adminRepository.update(user)
    }
    suspend fun delete(user: User) {
        adminRepository.delete(user)
    }
    suspend fun getAllUsers(): List<User> {
        return adminRepository.getAllUsers()
    }
    suspend fun insertBook(book: Book) {
        adminRepository.insertBook(book)
    }
    suspend fun updateBook(book: Book) {
        adminRepository.updateBook(book)
    }
    suspend fun deleteBook(book: Book) {
        adminRepository.deleteBook(book)
    }
    suspend fun insertCategory(category: Category) {
        adminRepository.insertCategory(category)
    }
    suspend fun updateCategory(category: Category) {
        adminRepository.updateCategory(category)
    }
    suspend fun deleteCategory(category: Category) {
        adminRepository.deleteCategory(category)
    }
    suspend fun getAllOrders(): List<Order> {
        return adminRepository.getAllOrders()
    }
}