package com.example.homeworkout.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityWarmupExerciseScreenBinding

class WarmupExerciseScreen : AppCompatActivity() {

    private lateinit var binding : ActivityWarmupExerciseScreenBinding
    private lateinit var WarmupExeList : ArrayList<ExeModel>
    private lateinit var timer : CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWarmupExerciseScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        var cPos = bundle!!.getInt("cPos")
        WarmupExeList = Constants.WarmupExeList()
        binding.image1.setImageResource(WarmupExeList[cPos].getImg())
        binding.image2.setImageResource(WarmupExeList[cPos].getImg1())
        cPos++
        var remTime = 10;
        var remTimeInMS = remTime*1000

        binding.exeBar.max = remTime
        binding.exeBar.progress = remTime
        binding.exeRemTime.text = remTime.toString()

        timer = object : CountDownTimer(remTimeInMS.toLong(),1000){
            override fun onTick(millisUntilFinished: Long) {
                remTime--
                binding.exeBar.progress = remTime
                binding.exeRemTime.text = remTime.toString()
            }

            override fun onFinish() {
                val intent = Intent(this@WarmupExerciseScreen,WarmupExerciseStart::class.java)
                var bundle1 = Bundle()
                bundle1.putInt("cPos",cPos)
                intent.putExtras(bundle1)
                startActivity(intent)
                finish()
            }

        }.start()
    }
}