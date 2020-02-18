package com.vadimkor.passwordmanagerv.ui_main.fragments.blank_fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vadimkor.passwordmanagerv.database.UserDatabase
import com.vadimkor.passwordmanagerv.database.UserRepository
import com.vadimkor.passwordmanagerv.model.UserEntity
import kotlinx.coroutines.launch

class BlankViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository
    val allUsers: LiveData<List<UserEntity>>

    init {
        val userDao = UserDatabase.getInstance(application).userDao()
        repository = UserRepository(userDao)
        allUsers = repository.allUsers
    }

    fun update(user: UserEntity) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: UserEntity) = viewModelScope.launch {
        repository.delete(user)
    }
}
