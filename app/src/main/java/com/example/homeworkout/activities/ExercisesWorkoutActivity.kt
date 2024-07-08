package com.example.homeworkout.activities

import android.content.Intent
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

        firebaseAuth = FirebaseAuth.getInstance()

        binding.backButton.setOnClickListener{
            var UID = firebaseAuth.uid.toString()
            val intent = Intent(this,WorkoutActivity::class.java)
            val bundle = Bundle()
            bundle.putString("UID",UID)
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }

        binding.buttonChestWorkout.setOnClickListener{
            val intent  = Intent(this, ExerciseChestActivity::class.java)
            startActivity(intent)
        }

        binding.buttonHandsWorkout.setOnClickListener{
            val intent  = Intent(this, ExerciseHandsActivity::class.java)
            startActivity(intent)
        }

        binding.buttonBackWorkout.setOnClickListener{
            val intent  = Intent(this, ExerciseBackActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLegsWorkout.setOnClickListener{
            val intent  = Intent(this, ExerciseLegsActivity::class.java)
            startActivity(intent)
        }

        binding.buttonAbsWorkout.setOnClickListener{
            val intent  = Intent(this, ExerciseAbsActivity::class.java)
            startActivity(intent)
        }

    }

}