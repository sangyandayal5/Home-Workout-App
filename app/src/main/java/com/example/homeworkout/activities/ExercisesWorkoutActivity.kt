package com.example.homeworkout.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityExercisesWorkoutBinding
import com.example.homeworkout.databinding.ActivityWorkoutBinding
import com.google.firebase.auth.FirebaseAuth

class ExercisesWorkoutActivity : AppCompatActivity(){

    private lateinit var binding: ActivityExercisesWorkoutBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityExercisesWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}