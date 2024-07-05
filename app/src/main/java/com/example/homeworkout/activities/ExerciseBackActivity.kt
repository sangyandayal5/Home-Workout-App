package com.example.homeworkout.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityExerciseAbsBinding
import com.example.homeworkout.databinding.ActivityExerciseBackBinding
import com.google.firebase.auth.FirebaseAuth

class ExerciseBackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBackBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBackBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}