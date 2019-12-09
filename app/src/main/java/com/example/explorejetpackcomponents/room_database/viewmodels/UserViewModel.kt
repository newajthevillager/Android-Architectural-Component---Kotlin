package com.example.explorejetpackcomponents.room_database.viewmodels

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.explorejetpackcomponents.room_database.models.User
import com.example.explorejetpackcomponents.room_database.room.UserDao
import com.example.explorejetpackcomponents.room_database.room.UserDatabase

class UserViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var userDao: UserDao
    lateinit var userDatabase: UserDatabase

    fun addUser(user: User) {
        InsertAsyncTask(userDao).execute(user)
    }

    fun showAllUsers() : LiveData<List<User>> {
        return userDao.getAllUsers()
    }

    init {
        userDatabase = UserDatabase.getDatabase(application)!!
        userDao = userDatabase.userDao()
    }

    private class InsertAsyncTask(var userDao: UserDao) : AsyncTask<User, Void, Void> () {
        override fun doInBackground(vararg users: User?): Void? {
            userDao.insertUser(users[0]!!)
            return null
        }

    }

}