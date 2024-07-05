package com.example.homeworkout.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityExerciseBackBinding
import com.example.homeworkout.databinding.ActivityExerciseChestBinding
import com.google.firebase.auth.FirebaseAuth

class ExerciseChestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseChestBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseChestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}