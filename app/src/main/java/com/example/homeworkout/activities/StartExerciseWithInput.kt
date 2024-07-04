package com.example.homeworkout.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityStartExerciseWithInputBinding

class StartExerciseWithInput : AppCompatActivity() {

    private lateinit var binding : ActivityStartExerciseWithInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartExerciseWithInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val imgSrc = bundle!!.getInt("ImgSrc")
        val exeName = bundle!!.getString("ExeName")
        binding.startBTN.setOnClickListener {
            val numberOfSets = binding.startNOS.text.toString()
            val nos = numberOfSets.toInt()
            val timePerSets = binding.startTPS.text.toString()
            val tps = timePerSets.toInt()
            if(nos > 0 && tps>0){
                val intent = Intent(this,ExerciseScreen::class.java)
                val bundle1 = Bundle()
                bundle1.putInt("imgSrc",imgSrc)
                bundle1.putInt("nos",nos)
                bundle1.putInt("tps",tps)
                bundle1.putString("exeName",exeName)
                intent.putExtras(bundle1)
                startActivity(intent)
                finish()
            }
        }
    }
}