package com.example.homeworkout.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityStartAgainExerciseBinding

class StartAgainExercise : AppCompatActivity() {

    private lateinit var binding : ActivityStartAgainExerciseBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartAgainExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val nos = bundle!!.getInt("nos")
        val tps = bundle!!.getInt("tps")
        val imgSrc = bundle!!.getInt("imgSrc")
        val exeName = bundle!!.getString("exeName")
        binding.setsRem.text = "Number Of sets Remaining : $nos"
        if(nos != 0){
            binding.startABTN.setOnClickListener {
                val intent = Intent(this, ExerciseScreen::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
                finish()
            }
        }
        else{
            val intent = Intent(this,FinishExerciseScreen::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }
    }
}