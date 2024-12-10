package com.haunp.mybookstore.presenters.fragment.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.domain.repository.IUserRepository
import com.haunp.mybookstore.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase, private val repository: IUserRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<UserEntity>()
    val loginResult: LiveData<UserEntity> get() = _loginResult

    fun login(username: String, password: String){
        viewModelScope.launch {
            val user = loginUseCase.invoke(username, password)
            _loginResult.value = user
        }
    }

    fun checkUserCredentials(username: String, password: String) {
        viewModelScope.launch {
            val isValid = repository.isUserValid(username, password)
            if (isValid) {
                // Xử lý khi thông tin đăng nhập hợp lệ
                login(username, password)
                showToast("Đăng nhập thành công!")
            } else {
                // Xử lý khi thông tin không hợp lệ
                showToast("Tên đăng nhập hoặc mật khẩu không đúng!")
            }
        }
    }

//    private fun createNewUser(username: String) {
//        viewModelScope.launch {
//            val newUser = UserEntity(
//                userId = 0, // Auto-increment
//                email = "default@example.com",
//                username = username,
//                phone = "0000000000",
//                address = "huynh tan phat",
//                password = "defaultPassword", // Đặt mật khẩu mặc định hoặc hỏi user
//                role = 1 // Giả sử role mặc định là 0
//            )
//            val userId = repository.registerUser(newUser)
//            if (userId > 0) {
//                showToast("User $username đã được tạo!")
//            } else {
//                showToast("Tạo user thất bại!")
//            }
//        }
//    }

    private fun showToast(message: String) {
        // Gọi UI toast hoặc event để hiện thông báo
    }
}