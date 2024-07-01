package com.example.homeworkout.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityMyHistoryBinding
import com.example.homeworkout.databinding.ActivityMyProfileBinding
import com.google.firebase.auth.FirebaseAuth

class MyHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyHistoryBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMyHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}