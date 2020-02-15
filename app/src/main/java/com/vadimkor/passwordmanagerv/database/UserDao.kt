package com.vadimkor.passwordmanagerv.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vadimkor.passwordmanagerv.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM list_users")  // ORDER BY website ASC
    fun getAll(): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)

    @Update
    suspend fun update(user: UserEntity)
}