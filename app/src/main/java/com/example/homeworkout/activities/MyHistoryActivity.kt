package com.example.homeworkout.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityMyHistoryBinding
import com.example.homeworkout.databinding.ActivityMyProfileBinding
import com.google.firebase.auth.FirebaseAuth

class MyHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyHistoryBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMyHistoryBinding.inflate(layoutInflater)
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

        var total = 0; // Change value after taking data from db

        var currentPage = (total+9)/10;

        binding.minusButton.setOnClickListener{

        }

        binding.plusButton.setOnClickListener{

        }

    }

}