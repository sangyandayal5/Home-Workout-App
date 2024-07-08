package com.example.homeworkout.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homeworkout.databinding.ActivityWorkoutBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class WorkoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkoutBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var uid: String

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        val db = Firebase.firestore
        val bundle = intent.extras
        uid = bundle!!.getString("UID", "-1")

        val currentContext = this  // Workaround to avoid capturing `this` in the lambda

        val docRef = db.collection("users").document(uid)
        docRef.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                val fname = document.data?.get("fname").toString()
//                val lname = document.data?.get("lname").toString()
                val userName = "$fname"
                currentContext.cname(userName)  // Use the local context reference
                Log.d("WorkoutActivity", "data : ${document.data}")
            } else {
                Log.d("WorkoutActivity", "No data")
            }
        }
            .addOnFailureListener { exception ->
                Log.d("WorkoutActivity", "get failed with ", exception)
            }

        binding.buttonQuickWorkout.setOnClickListener{
            val intent  = Intent(this, WarmupExerciseStart::class.java)
            val bundle = Bundle()
            bundle.putInt("cPos",0)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.buttonCreateWorkout.setOnClickListener{
            val intent  = Intent(this, ExercisesWorkoutActivity::class.java)
            startActivity(intent)
        }

        binding.buttonHistory.setOnClickListener{
            val intent  = Intent(this, MyHistoryActivity::class.java)
            startActivity(intent)
        }

        binding.buttonProfile.setOnClickListener{
            val intent  = Intent(this, MyProfileActivity::class.java)
            startActivity(intent)
        }

    }

    private fun cname(userName: String) {
        val displayText = "Hey, $userName"
        val textView = binding.awUName
        textView.text = displayText
    }
}