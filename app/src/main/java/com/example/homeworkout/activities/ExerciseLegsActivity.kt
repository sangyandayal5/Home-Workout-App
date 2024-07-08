package com.example.homeworkout.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.R
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
        var bundle = Bundle()

        binding.backButton.setOnClickListener{
            val intent  = Intent(this, ExercisesWorkoutActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLegs1Workout.setOnClickListener {
            val intent = Intent(this@ExerciseLegsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Squats")
            bundle.putInt("imgSrc", R.drawable.legs_1_squats_1)
            bundle.putInt("imgSrc1", R.drawable.legs_1_squats_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonLegs2Workout.setOnClickListener {
            val intent = Intent(this@ExerciseLegsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Backward Lunges")
            bundle.putInt("imgSrc", R.drawable.legs_2_backward_lunges_1)
            bundle.putInt("imgSrc1", R.drawable.legs_2_backward_lunges_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonLegs3Workout.setOnClickListener {
            val intent = Intent(this@ExerciseLegsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Donkey kicks")
            bundle.putInt("imgSrc", R.drawable.legs_3_donkey_kicks_1)
            bundle.putInt("imgSrc1", R.drawable.legs_3_donkey_kicks_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonLegs4Workout.setOnClickListener {
            val intent = Intent(this@ExerciseLegsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Wall Calf Raises")
            bundle.putInt("imgSrc", R.drawable.legs_4_wall_calf_raises_1)
            bundle.putInt("imgSrc1", R.drawable.legs_4_wall_calf_raises_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonLegs5Workout.setOnClickListener {
            val intent = Intent(this@ExerciseLegsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Side Lying Leg Lift")
            bundle.putInt("imgSrc", R.drawable.legs_5_side_lying_leg_lift_1)
            bundle.putInt("imgSrc1", R.drawable.legs_5_side_lying_leg_lift_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}