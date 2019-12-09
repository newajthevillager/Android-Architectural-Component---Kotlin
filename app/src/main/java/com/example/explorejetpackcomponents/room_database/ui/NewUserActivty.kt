package com.example.explorejetpackcomponents.room_database.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.explorejetpackcomponents.R
import com.example.explorejetpackcomponents.room_database.models.User
import kotlinx.android.synthetic.main.activity_new_user_activty.*
import kotlinx.android.synthetic.main.activity_users.*

class NewUserActivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user_activty)

        btnSaveUser.setOnClickListener {
            var name = etName.text.toString()
            var age = etAge.text.toString().toInt()
            var gender = etGender.text.toString()
            var country = etCountry.text.toString()
            var profession = etProfession.text.toString()

            var user: User = User(name, age, gender, country, profession)
            var intent = Intent()
            intent.putExtra(getString(R.string.userKey), user)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}
