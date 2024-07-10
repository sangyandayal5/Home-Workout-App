package com.example.homeworkout.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityMyHistoryBinding
import com.example.homeworkout.databinding.ActivityMyProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.Integer.max
import java.lang.Math.min

class MyHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyHistoryBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMyHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        var uid = firebaseAuth.uid.toString()
        val db = Firebase.firestore
        binding.backButton.setOnClickListener{

            val intent = Intent(this,WorkoutActivity::class.java)
            val bundle = Bundle()
            bundle.putString("UID",uid)
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }
        makeInvi()
        binding.minusButton.visibility = View.GONE
        binding.plusButton.visibility = View.GONE
        binding.before.visibility = View.GONE
        binding.after.visibility = View.GONE
        binding.slash.visibility = View.GONE
        var total : Int = 0
        var cnt : Int = 0
        var sze : Int = 0
        val exeRef = db.collection("history").document(uid)
        var name = ArrayList<String>()
        var date = ArrayList<String>()
        var set = ArrayList<Int>()
        exeRef.get().addOnSuccessListener { document->
            if (document != null && document.exists()){
                date = document.data?.get("date") as ArrayList<String>
                name = document.data?.get("name") as ArrayList<String>
                set = document.data?.get("num") as ArrayList<Int>

                binding.minusButton.visibility = View.VISIBLE
                binding.plusButton.visibility = View.VISIBLE
                binding.before.visibility = View.VISIBLE
                binding.after.visibility = View.VISIBLE
                binding.slash.visibility = View.VISIBLE


                sze = name.size
                total = ((sze+9)/10).toInt()
                cnt = 1

                binding.before.text = cnt.toString()
                binding.after.text = total.toString()

                load(cnt,sze, name, date, set)
                Log.d("History", "data : ${document.data}")
            }
            else{
                Log.d("History", "No data")
            }
        }


        binding.minusButton.setOnClickListener{
            if(cnt>1){
                cnt--;
                binding.before.text = cnt.toString()
                makeInvi()
                load(cnt, sze, name, date, set)
            }
        }

        binding.plusButton.setOnClickListener{
            if(cnt<total){
                cnt++
                binding.before.text = cnt.toString()
                makeInvi()
                load(cnt, sze, name, date, set)
            }
        }

    }

    @SuppressLint("SetTextI18n")
    fun load(cnt : Int, sze : Int, name : ArrayList<String>, date : ArrayList<String>, set : ArrayList<Int>){
        var maxs : Int = (cnt * 10).coerceAtMost(sze)
        var iniv = (cnt-1)*10
        Log.d("History","$maxs")
        binding.line11.visibility = View.VISIBLE
        binding.line12.visibility = View.VISIBLE
        binding.line13.visibility = View.VISIBLE
        binding.line14.visibility = View.VISIBLE
        binding.line11.text = (iniv+1).toString()
        binding.line12.text = name[iniv]
        binding.line13.text = date[iniv]
        binding.line14.text = set[iniv].toString()
        iniv++
//        return
        if(iniv == maxs) return

        binding.line21.visibility = View.VISIBLE
        binding.line22.visibility = View.VISIBLE
        binding.line23.visibility = View.VISIBLE
        binding.line24.visibility = View.VISIBLE
        binding.line21.text = (iniv+1).toString()
        binding.line22.text = name[iniv]
        binding.line23.text = date[iniv]
        binding.line24.text = set[iniv].toString()
        iniv++
        if(iniv == maxs) return

        binding.line31.visibility = View.VISIBLE
        binding.line32.visibility = View.VISIBLE
        binding.line33.visibility = View.VISIBLE
        binding.line34.visibility = View.VISIBLE
        binding.line31.text = (iniv+1).toString()
        binding.line32.text = name[iniv]
        binding.line33.text = date[iniv]
        binding.line34.text = set[iniv].toString()
        iniv++
        if(iniv == maxs) return

        binding.line41.visibility = View.VISIBLE
        binding.line42.visibility = View.VISIBLE
        binding.line43.visibility = View.VISIBLE
        binding.line44.visibility = View.VISIBLE
        binding.line41.text = (iniv+1).toString()
        binding.line42.text = name[iniv]
        binding.line43.text = date[iniv]
        binding.line44.text = set[iniv].toString()
        iniv++
        if(iniv == maxs) return

        binding.line51.visibility = View.VISIBLE
        binding.line52.visibility = View.VISIBLE
        binding.line53.visibility = View.VISIBLE
        binding.line54.visibility = View.VISIBLE
        binding.line51.text = (iniv+1).toString()
        binding.line52.text = name[iniv]
        binding.line53.text = date[iniv]
        binding.line54.text = set[iniv].toString()
        iniv++
        if(iniv == maxs) return

        binding.line61.visibility = View.VISIBLE
        binding.line62.visibility = View.VISIBLE
        binding.line63.visibility = View.VISIBLE
        binding.line64.visibility = View.VISIBLE
        binding.line61.text = (iniv+1).toString()
        binding.line62.text = name[iniv]
        binding.line63.text = date[iniv]
        binding.line64.text = set[iniv].toString()
        iniv++
        if(iniv == maxs) return

        binding.line71.visibility = View.VISIBLE
        binding.line72.visibility = View.VISIBLE
        binding.line73.visibility = View.VISIBLE
        binding.line74.visibility = View.VISIBLE
        binding.line71.text = (iniv+1).toString()
        binding.line72.text = name[iniv]
        binding.line73.text = date[iniv]
        binding.line74.text = set[iniv].toString()
        iniv++
        if(iniv == maxs) return

        binding.line81.visibility = View.VISIBLE
        binding.line82.visibility = View.VISIBLE
        binding.line83.visibility = View.VISIBLE
        binding.line84.visibility = View.VISIBLE
        binding.line81.text = (iniv+1).toString()
        binding.line82.text = name[iniv]
        binding.line83.text = date[iniv]
        binding.line84.text = set[iniv].toString()
        iniv++
        if(iniv == maxs) return

        binding.line91.visibility = View.VISIBLE
        binding.line92.visibility = View.VISIBLE
        binding.line93.visibility = View.VISIBLE
        binding.line94.visibility = View.VISIBLE
        binding.line91.text = (iniv+1).toString()
        binding.line92.text = name[iniv]
        binding.line93.text = date[iniv]
        binding.line94.text = set[iniv].toString()
        iniv++
        if(iniv == maxs) return

        binding.line101.visibility = View.VISIBLE
        binding.line102.visibility = View.VISIBLE
        binding.line103.visibility = View.VISIBLE
        binding.line104.visibility = View.VISIBLE
        binding.line101.text = (iniv+1).toString()
        binding.line102.text = name[iniv]
        binding.line103.text = date[iniv]
        binding.line104.text = set[iniv].toString()
        iniv++
        if(iniv == maxs) return
    }

    fun makeInvi(){
        binding.line11.visibility = View.GONE
        binding.line12.visibility = View.GONE
        binding.line13.visibility = View.GONE
        binding.line14.visibility = View.GONE

        binding.line21.visibility = View.GONE
        binding.line22.visibility = View.GONE
        binding.line23.visibility = View.GONE
        binding.line24.visibility = View.GONE

        binding.line31.visibility = View.GONE
        binding.line32.visibility = View.GONE
        binding.line33.visibility = View.GONE
        binding.line34.visibility = View.GONE

        binding.line41.visibility = View.GONE
        binding.line42.visibility = View.GONE
        binding.line43.visibility = View.GONE
        binding.line44.visibility = View.GONE

        binding.line51.visibility = View.GONE
        binding.line52.visibility = View.GONE
        binding.line53.visibility = View.GONE
        binding.line54.visibility = View.GONE

        binding.line61.visibility = View.GONE
        binding.line62.visibility = View.GONE
        binding.line63.visibility = View.GONE
        binding.line64.visibility = View.GONE

        binding.line71.visibility = View.GONE
        binding.line72.visibility = View.GONE
        binding.line73.visibility = View.GONE
        binding.line74.visibility = View.GONE

        binding.line81.visibility = View.GONE
        binding.line82.visibility = View.GONE
        binding.line83.visibility = View.GONE
        binding.line84.visibility = View.GONE

        binding.line91.visibility = View.GONE
        binding.line92.visibility = View.GONE
        binding.line93.visibility = View.GONE
        binding.line94.visibility = View.GONE

        binding.line101.visibility = View.GONE
        binding.line102.visibility = View.GONE
        binding.line103.visibility = View.GONE
        binding.line104.visibility = View.GONE
    }

}