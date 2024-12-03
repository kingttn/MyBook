package com.haunp.mybookstore.presenters.fragment.user.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.haunp.mybookstore.domain.entity.UserEntity

class SettingViewModel : ViewModel() {
    private val _user = MutableLiveData<UserEntity?>()
    val user: LiveData<UserEntity?> = _user

    fun setUser(user: UserEntity){
        _user.value = user
    }
<<<<<<< Updated upstream

    fun logout(){
        _user.value = null
    }


=======
    fun logout(){
        _user.value = null
    }
>>>>>>> Stashed changes
}