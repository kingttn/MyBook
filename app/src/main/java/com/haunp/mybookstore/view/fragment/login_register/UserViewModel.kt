package com.haunp.mybookstore.view.fragment.login_register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.data.model.entity.User
import com.haunp.mybookstore.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    fun register(username: String, password: String, email: String, phone: String, address: String) {
        val user = User(email = email, password = password, username = username, phone = phone, address = address, role = false)
        viewModelScope.launch {
            repository.register(user)
        }
    }
    fun login(username: String, password: String, onResult: (User?) -> Unit) {
        viewModelScope.launch {
            val user = repository.login(username, password)
            withContext(Dispatchers.Main) {
                onResult(user)
            }
        }
    }
    fun registerAdmin(username: String, password: String, email: String, phone: String, address: String) {
        val user = User(email = email, password = password, username = username, phone = phone, address = address, role = true)
        viewModelScope.launch {
            repository.register(user)
        }
    }
}