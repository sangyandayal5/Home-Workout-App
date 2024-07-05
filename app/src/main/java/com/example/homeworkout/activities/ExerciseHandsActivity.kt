package com.example.homeworkout.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityExerciseChestBinding
import com.example.homeworkout.databinding.ActivityExerciseHandsBinding
import com.google.firebase.auth.FirebaseAuth

class ExerciseHandsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseHandsBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseHandsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}