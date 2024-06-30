package com.example.homeworkout.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivitySignInBinding
import com.example.homeworkout.databinding.ActivityWorkoutBinding
import com.google.firebase.auth.FirebaseAuth

class WorkoutActivity : AppCompatActivity() {

    private lateinit var binding:ActivityWorkoutBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}