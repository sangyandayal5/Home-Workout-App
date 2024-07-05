package com.example.homeworkout.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityExerciseHandsBinding
import com.example.homeworkout.databinding.ActivityExerciseLegsBinding
import com.google.firebase.auth.FirebaseAuth

class ExerciseLegsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseLegsBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseLegsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}