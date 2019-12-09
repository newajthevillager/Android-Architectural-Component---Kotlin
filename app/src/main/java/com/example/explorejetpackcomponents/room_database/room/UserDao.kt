package com.example.explorejetpackcomponents.room_database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.explorejetpackcomponents.room_database.models.User

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<List<User>>

}