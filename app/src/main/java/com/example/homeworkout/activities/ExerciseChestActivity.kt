package com.example.homeworkout.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.R
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
        var bundle = Bundle()
        binding.buttonChest1Workout.setOnClickListener {
            val intent = Intent(this@ExerciseChestActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Push-ups")
            bundle.putInt("imgSrc", R.drawable.chest_1_push_up_1)
            bundle.putInt("imgSrc1", R.drawable.chest_1_push_up_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonChest2Workout.setOnClickListener {
            val intent = Intent(this@ExerciseChestActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Cobra Stretch")
            bundle.putInt("imgSrc", R.drawable.chest_2_cobra_stretch_1)
            bundle.putInt("imgSrc1", R.drawable.chest_2_cobra_stretch_1)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonChest3Workout.setOnClickListener {
            val intent = Intent(this@ExerciseChestActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Knee Push-ups")
            bundle.putInt("imgSrc", R.drawable.chest_3_knee_push_up_1)
            bundle.putInt("imgSrc1", R.drawable.chest_3_knee_push_up_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonChest4Workout.setOnClickListener {
            val intent = Intent(this@ExerciseChestActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Wide-arm Push-ups")
            bundle.putInt("imgSrc", R.drawable.chest_4_widearm_push_up_1)
            bundle.putInt("imgSrc1", R.drawable.chest_4_widearm_push_up_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonChest5Workout.setOnClickListener {
            val intent = Intent(this@ExerciseChestActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Decline Push-ups")
            bundle.putInt("imgSrc", R.drawable.chest_5_decline_push_up_1)
            bundle.putInt("imgSrc1", R.drawable.chest_5_decline_push_up_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}