package com.example.homeworkout.activities

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        val uid = firebaseAuth.uid.toString()
        val exeName = bundle!!.getString("exeName").toString()
        val nos = bundle!!.getInt("onos")
        val cDate = LocalDate.now().toString()
        var name = ArrayList<String>()
        var date = ArrayList<String>()
        var num  = ArrayList<Int>()
        name.add(exeName)
        date.add(cDate)
        num.add(nos)
        val exeRef = uid.let { db.collection("history").document(it) }
//        exeRef?.set(exercise)
        exeRef.get().addOnSuccessListener{ document ->
            if (document != null && document.exists()){
                val pdate = document.data?.get("date")
                val pname = document.data?.get("name")
                val pnum = document.data?.get("num")
                name.addAll(pname as Collection<String>)
                date.addAll(pdate as Collection<String>)
                num.addAll(pnum as Collection<Int>)
                val his = hashMapOf(
                    "name" to name,
                    "date" to date,
                    "num" to num
                )
                exeRef.set(his)
                Log.d("Finish", "data : ${document.data}")
            }
            else{
                val his = hashMapOf(
                    "name" to name,
                    "date" to date,
                    "num" to num
                )
                exeRef.set(his)
                Log.d("Finish", "No data")
            }
        }
        binding.endBTN.setOnClickListener {
            finish()
        }
    }
}