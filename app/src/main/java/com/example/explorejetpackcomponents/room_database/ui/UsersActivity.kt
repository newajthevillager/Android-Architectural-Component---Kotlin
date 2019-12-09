package com.example.explorejetpackcomponents.room_database.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.explorejetpackcomponents.R
import com.example.explorejetpackcomponents.room_database.adapters.UserAdapter
import com.example.explorejetpackcomponents.room_database.models.User
import com.example.explorejetpackcomponents.room_database.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.activity_new_user_activty.*
import kotlinx.android.synthetic.main.activity_users.*

class UsersActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )

        btnAddUser.setOnClickListener {
            var intent = Intent(this, NewUserActivty::class.java)
            startActivityForResult(intent, 0)
        }

        userViewModel.showAllUsers().observe(this, Observer {
            var adapter = UserAdapter(it)
            rvUsers.layoutManager = layoutManager
            rvUsers.adapter = adapter
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            var user: User = data?.getSerializableExtra(getString(R.string.userKey)) as User
            userViewModel.addUser(user)
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Not Ok", Toast.LENGTH_SHORT).show()
        }
    }

}
