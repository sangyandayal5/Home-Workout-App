package com.example.homeworkout.activities

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityFinishExerciseScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.type.Date
import java.time.LocalDate

class FinishExerciseScreen : AppCompatActivity() {

    private lateinit var binding : ActivityFinishExerciseScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishExerciseScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        val db = Firebase.firestore
        val bundle = intent.extras
        val uid = firebaseAuth.uid
        val exeName = bundle!!.getString("exeName")
        val nos = bundle!!.getInt("nos")
        val cDate = LocalDate.now()
        val exercise = hashMapOf(
            "name" to exeName,
            "nos" to nos,
            "date" to cDate
        )
//        val exeRef = uid?.let { db.collection("history").document(it) }
//        exeRef?.set(exercise)
        binding.endBTN.setOnClickListener {
//            val intent = Intent(this,ExercisesWorkoutActivity::class.java)
//            startActivity(intent)
            finish()
        }
    }
}