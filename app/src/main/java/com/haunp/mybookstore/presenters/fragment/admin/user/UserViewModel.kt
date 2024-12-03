package com.haunp.mybookstore.presenters.fragment.admin.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.haunp.mybookstore.domain.entity.UserEntity
import com.haunp.mybookstore.domain.usecase.GetAccountUseCase
import com.haunp.mybookstore.domain.usecase.RegisterUseCase
import kotlinx.coroutines.launch

class UserViewModel(private val getAccountUseCase: GetAccountUseCase,private val registerUseCase: RegisterUseCase) : ViewModel() {
    val users: LiveData<List<UserEntity>> = liveData {
        emitSource(getAccountUseCase().asLiveData())
    }

    fun registerUser(userEntity: UserEntity) {
        viewModelScope.launch {
            registerUseCase.invoke(userEntity)
        }
    }
}