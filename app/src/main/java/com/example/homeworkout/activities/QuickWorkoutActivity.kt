package com.example.homeworkout.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityQuickWorkoutBinding
import com.example.homeworkout.databinding.ActivityWorkoutBinding
import com.google.firebase.auth.FirebaseAuth

class QuickWorkoutActivity : AppCompatActivity(){

    private lateinit var binding: ActivityQuickWorkoutBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityQuickWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}