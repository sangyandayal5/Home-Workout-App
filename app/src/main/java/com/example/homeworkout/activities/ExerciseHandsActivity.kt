package com.example.homeworkout.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.R
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
        var bundle = Bundle()
        binding.buttonHands1Workout.setOnClickListener {
            val intent = Intent(this@ExerciseHandsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Floor Triceps Dips")
            bundle.putInt("imgSrc", R.drawable.hands_1_floor_tricep_dips_1)
            bundle.putInt("imgSrc1", R.drawable.hands_1_floor_tricep_dips_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonHands2Workout.setOnClickListener {
            val intent = Intent(this@ExerciseHandsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Rotational Push-up")
            bundle.putInt("imgSrc", R.drawable.hands_2_rotational_push_up_1)
            bundle.putInt("imgSrc1", R.drawable.hands_2_rotational_push_up_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonHands3Workout.setOnClickListener {
            val intent = Intent(this@ExerciseHandsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Leg Barbell Curl")
            bundle.putInt("imgSrc", R.drawable.hands_3_leg_barbell_curl_1)
            bundle.putInt("imgSrc1", R.drawable.hands_3_leg_barbell_curl_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonHands4Workout.setOnClickListener {
            val intent = Intent(this@ExerciseHandsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Arm Scissors")
            bundle.putInt("imgSrc", R.drawable.hands_4_arm_scissors_1)
            bundle.putInt("imgSrc1", R.drawable.hands_4_arm_scissors_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonHands5Workout.setOnClickListener {
            val intent = Intent(this@ExerciseHandsActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Triceps Stretch")
            bundle.putInt("imgSrc", R.drawable.hands_5_triceps_stretch_1)
            bundle.putInt("imgSrc1", R.drawable.hands_5_triceps_stretch_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}