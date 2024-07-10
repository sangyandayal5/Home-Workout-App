package com.example.homeworkout.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityIntroPageBinding

class IntroPage : AppCompatActivity() {

    private lateinit var binding: ActivityIntroPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonStart.setOnClickListener{
            val intent = Intent(this@IntroPage,ChoicePage::class.java)
            startActivity(intent)
        }
    }
}