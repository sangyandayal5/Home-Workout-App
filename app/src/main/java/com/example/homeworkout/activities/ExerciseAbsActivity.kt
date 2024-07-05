package com.example.homeworkout.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityExerciseAbsBinding
import com.example.homeworkout.databinding.ActivityExercisesWorkoutBinding
import com.google.firebase.auth.FirebaseAuth

class ExerciseAbsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseAbsBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityExerciseAbsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}