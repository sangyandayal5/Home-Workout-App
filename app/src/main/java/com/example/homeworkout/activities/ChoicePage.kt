package com.example.homeworkout.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityChoicePageBinding

class ChoicePage : AppCompatActivity() {

    private lateinit var binding: ActivityChoicePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoicePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonRegisterAccountOptions.setOnClickListener{
            val intent = Intent(this@ChoicePage,LoginRegisterActivity::class.java)
            startActivity(intent)
        }
        binding.buttonLoginAccountOptions.setOnClickListener{
            val intent = Intent(this@ChoicePage,SignInActivity::class.java)
            startActivity(intent)
        }
    }
}