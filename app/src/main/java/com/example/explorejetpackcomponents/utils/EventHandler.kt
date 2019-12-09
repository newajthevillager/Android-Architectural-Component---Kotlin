package com.example.explorejetpackcomponents.utils

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.example.explorejetpackcomponents.data_binding.ui.MoviesActivity
import com.example.explorejetpackcomponents.room_database.ui.UsersActivity

class EventHandler {

    fun navigateToMoviesActivity(view: View) {
        var intent: Intent = Intent(view.context, MoviesActivity::class.java);
        view.context.startActivity(intent)
    }

    fun navigateToUsersActivity(view: View) {
        var intent: Intent = Intent(view.context, UsersActivity::class.java);
        view.context.startActivity(intent)
    }

}