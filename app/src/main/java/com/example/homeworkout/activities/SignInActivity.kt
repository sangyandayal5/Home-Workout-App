package com.example.homeworkout.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignInBinding
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.tvDontHaveAccount.setOnClickListener{
            val intent  = Intent(this, LoginRegisterActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLoginLogin.setOnClickListener{
            val email = binding.edEmailLogin.text.toString()
            val password = binding.edPasswordLogin.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                if(email.isValidEmail()){
                    if(password.length >=6){
                        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                            if(it.isSuccessful){
                                val intent = Intent(this,WorkoutActivity::class.java)
                                startActivity(intent)
                            }
                            else{
                                Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    else{
                        Toast.makeText(this,"Length of Password Should me greater than 5", Toast.LENGTH_LONG).show()
                    }
                }
                else{
                    Toast.makeText(this,"Invalid Email", Toast.LENGTH_LONG).show()
                }

            }
            else{
                Toast.makeText(this,"Empty Fields are not allowed", Toast.LENGTH_LONG).show()
            }
        }
    }
}