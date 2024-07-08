package com.example.homeworkout.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.R
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
        var bundle = Bundle()

        binding.backButton.setOnClickListener{
            val intent  = Intent(this, ExercisesWorkoutActivity::class.java)
            startActivity(intent)
        }

        binding.buttonAbs1Workout.setOnClickListener {
            val intent = Intent(this@ExerciseAbsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Jumping Jack")
            bundle.putInt("imgSrc",R.drawable.abs_1_jumping_jacks_1)
            bundle.putInt("imgSrc1",R.drawable.abs_1_jumping_jacks_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonAbs2Workout.setOnClickListener {
            val intent = Intent(this@ExerciseAbsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Abdominal Crunches")
            bundle.putInt("imgSrc",R.drawable.abs_2_abdominal_crunches_1)
            bundle.putInt("imgSrc1",R.drawable.abs_2_abdominal_crunches_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonAbs3Workout.setOnClickListener {
            val intent = Intent(this@ExerciseAbsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Planks")
            bundle.putInt("imgSrc",R.drawable.abs_3_plank_1)
            bundle.putInt("imgSrc1",R.drawable.abs_3_plank_1)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonAbs4Workout.setOnClickListener {
            val intent = Intent(this@ExerciseAbsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Russian Twist")
            bundle.putInt("imgSrc",R.drawable.abs_4_russian_twist_1)
            bundle.putInt("imgSrc1",R.drawable.abs_4_russian_twist_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonAbs5Workout.setOnClickListener {
            val intent = Intent(this@ExerciseAbsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Heel Touch")
            bundle.putInt("imgSrc",R.drawable.abs_5_heal_touch_1)
            bundle.putInt("imgSrc1",R.drawable.abs_5_heal_touch_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}