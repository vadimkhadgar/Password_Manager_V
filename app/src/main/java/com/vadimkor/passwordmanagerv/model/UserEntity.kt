package com.vadimkor.passwordmanagerv.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_users")
data class UserEntity(
    @ColumnInfo(name = "website") var website: String,
    @ColumnInfo(name = "login") var login: String,
    @ColumnInfo(name = "password") var password: String,
    var expanded: Boolean = false

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}