package com.example.homeworkout.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityMyProfileBinding
import com.example.homeworkout.databinding.ActivityQuickWorkoutBinding
import com.google.firebase.auth.FirebaseAuth

class MyProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyProfileBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}