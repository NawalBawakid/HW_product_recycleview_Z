package com.example.hw_product_recycleview.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_product_recycleview.R
import com.example.hw_product_recycleview.databinding.ActivityMainBinding
import com.example.hw_product_recycleview.databinding.ActivityMainLastBinding

class MainActivityLast : AppCompatActivity() {
    lateinit var binding: ActivityMainLastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainLastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.extras?.getString("name")
        val image = intent.extras?.getInt("image")

        binding.finalimage.setImageResource(image!!)
        binding.iphonename.text = name


    }
}