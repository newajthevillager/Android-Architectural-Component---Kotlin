package com.example.explorejetpackcomponents.room_database.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.explorejetpackcomponents.R
import com.example.explorejetpackcomponents.room_database.models.User
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(var users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user = users[position]
        holder.setData(user)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(user: User) {
            itemView.tvUserName.text = "Name : " + user.name
            itemView.tvUserAge.text = "Age : " + user.age.toString()
            itemView.tvUserGender.text = "Gender : " + user.gender
            itemView.tvUserCountry.text = "Country : " + user.country
            itemView.tvUserProfession.text = "Profession" + user.profession
        }

    }

}