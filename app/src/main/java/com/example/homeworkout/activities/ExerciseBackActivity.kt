package com.example.homeworkout.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.R
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
        var bundle = Bundle()

        binding.backButton.setOnClickListener{
            val intent  = Intent(this, ExercisesWorkoutActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLegs1Workout.setOnClickListener {
            val intent = Intent(this@ExerciseBackActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Triceps Kickbacks")
            bundle.putInt("imgSrc", R.drawable.back_1_triceps_kickbacks_1)
            bundle.putInt("imgSrc1",R.drawable.back_1_triceps_kickbacks_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonLegs2Workout.setOnClickListener {
            val intent = Intent(this@ExerciseBackActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Cat-Cow Pose")
            bundle.putInt("imgSrc", R.drawable.back_2_cat_cow_pose_1)
            bundle.putInt("imgSrc1",R.drawable.back_2_cat_cow_pose_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonLegs3Workout.setOnClickListener {
            val intent = Intent(this@ExerciseBackActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Hinge Hips")
            bundle.putInt("imgSrc", R.drawable.back_3_hip_hinge_1)
            bundle.putInt("imgSrc1",R.drawable.back_3_hip_hinge_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonLegs4Workout.setOnClickListener {
            val intent = Intent(this@ExerciseBackActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Incline Push-ups")
            bundle.putInt("imgSrc", R.drawable.back_4_incline_push_up_1)
            bundle.putInt("imgSrc1",R.drawable.back_4_incline_push_up_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.buttonLegs5Workout.setOnClickListener {
            val intent = Intent(this@ExerciseBackActivity,StartExerciseWithInput::class.java)
            bundle.putString("exeName","Floor Triceps dips")
            bundle.putInt("imgSrc", R.drawable.back_5_floor_triceps_dips_1)
            bundle.putInt("imgSrc1",R.drawable.back_5_floor_triceps_dips_2)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}