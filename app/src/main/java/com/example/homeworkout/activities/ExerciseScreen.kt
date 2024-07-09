package com.example.homeworkout.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityExerciseScreenBinding

class ExerciseScreen : AppCompatActivity() {

    private lateinit var binding : ActivityExerciseScreenBinding
    private lateinit var timer : CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        var nos = bundle!!.getInt("nos")
        val onos = bundle!!.getInt("onos")
        val tps = bundle!!.getInt("tps")
        val imgSrc = bundle!!.getInt("imgSrc")
        val imgSrc1 = bundle!!.getInt("imgSrc1")
        val exeName = bundle!!.getString("exeName")
        binding.image1.setImageResource(imgSrc)
        binding.image2.setImageResource(imgSrc1)
        binding.exeName.text = exeName
        binding.exeBar.max = tps
        binding.exeBar.progress = tps
        var remTime = tps
        var remTimeInMS = tps*1000
        binding.exeRemTime.text = tps.toString()
        nos--
        timer = object : CountDownTimer(remTimeInMS.toLong(),1000){
            override fun onTick(millisUntilFinished: Long) {
                remTime--
                binding.exeBar.progress = remTime
                binding.exeRemTime.text = remTime.toString()
            }

            override fun onFinish() {
                val intent = Intent(this@ExerciseScreen,StartAgainExercise::class.java)
                var bundle1 = Bundle()
                bundle1.putInt("imgSrc",imgSrc)
                bundle1.putInt("imgSrc1",imgSrc1)
                bundle1.putInt("nos",nos)
                bundle1.putInt("onos",onos)
                bundle1.putInt("tps",tps)
                bundle1.putString("exeName",exeName)
                intent.putExtras(bundle1)
                startActivity(intent)
                finish()
            }

        }.start()
    }
}