package com.example.homeworkout.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityMyProfileBinding
import com.example.homeworkout.databinding.ActivityQuickWorkoutBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MyProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyProfileBinding
    private lateinit var  firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        val uid = firebaseAuth.uid.toString()
        val db = Firebase.firestore
        val docRef = uid.let { db.collection("users").document(it) }
        docRef.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                val fname = document.data?.get("fname").toString()
                val lname = document.data?.get("lname").toString()
                val email = document.data?.get("email").toString()
                upd(fname,lname,email)
                Log.d("Profile", "data : ${document.data}")
            } else {
                Log.d("Profile", "No data")
            }
        }
    }
    private fun upd(fName : String,lName : String,email : String){
        binding.fillFirstName.text = fName
        binding.fillLastName.text = lName
        binding.fillEmail.text = email
    }
}