package com.example.explorejetpackcomponents.room_database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.explorejetpackcomponents.room_database.models.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var databaseInstance: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase? {
            if (databaseInstance == null) {
                synchronized(UserDatabase::class.java) {
                    databaseInstance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                    "users_db"
                    ).build()
                }
            }
            return databaseInstance
        }

    }

}