package com.vadimkor.passwordmanagerv

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.vadimkor.passwordmanagerv.database.UserDatabase
import com.vadimkor.passwordmanagerv.database.UserRepository
import com.vadimkor.passwordmanagerv.model.UserEntity
import kotlinx.coroutines.launch

class AddUserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getInstance(application).userDao()
        repository = UserRepository(userDao)
    }

    fun addUser(website: String, username: String, password: String) = viewModelScope.launch {
        repository.insert(UserEntity(website, username, password))
    }
}
