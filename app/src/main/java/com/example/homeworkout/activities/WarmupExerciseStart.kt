package com.example.homeworkout.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homeworkout.databinding.ActivityWarmupExerciseStartBinding

class WarmupExerciseStart : AppCompatActivity() {

    private lateinit var binding : ActivityWarmupExerciseStartBinding
    private lateinit var WarmupExeList : ArrayList<ExeModel>
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWarmupExerciseStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        var cPos = bundle!!.getInt("cPos")
        WarmupExeList = Constants.WarmupExeList()
        if(cPos == 5){
            val intent = Intent(this@WarmupExerciseStart,FinishExerciseScreen::class.java)
            val bundle1 = Bundle()
            bundle1.putString("exeName","WarmUp")
            bundle1.putInt("nos",1)
            intent.putExtras(bundle1)
            startActivity(intent)
            finish()
        }
        if(cPos != 0){
            binding.startABTN.text = "Start Again"
            binding.textView3.visibility = View.VISIBLE
        }
        binding.setsRem.text = "Next : ${WarmupExeList[cPos].getName()}"
        binding.textView4.text = "Number Of Exercise remaining : ${5-cPos}"
        binding.startABTN.setOnClickListener {
            val intent = Intent(this@WarmupExerciseStart,WarmupExerciseScreen::class.java)
            val bundle1 = Bundle()
            bundle1.putInt("cPos",cPos)
            intent.putExtras(bundle1)
            startActivity(intent)
            finish()
        }
    }
}