package com.example.explorejetpackcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.explorejetpackcomponents.utils.EventHandler
import com.example.explorejetpackcomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.handler = EventHandler()
    }
}


