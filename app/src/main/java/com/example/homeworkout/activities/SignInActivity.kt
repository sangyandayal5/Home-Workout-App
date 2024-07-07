package com.example.homeworkout.activities

import android.app.PendingIntent.OnFinished
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityCutomToastBinding
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

        binding.tvForgotPasswordLogin.setOnClickListener{
            val intent  = Intent(this, ForgetPasswordActivity::class.java)
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
                                var UID = firebaseAuth.uid.toString()
                                val intent = Intent(this,WorkoutActivity::class.java)
                                val bundle = Bundle()
                                bundle.putString("UID",UID)
                                intent.putExtras(bundle)
                                startActivity(intent)
                                finish()
                            }
                            else{
                                showCustomToast("Login Failed. Please try again")
                            }
                        }
                    }
                    else{
                        showCustomToast("Length of Password should be atleast 6")
                    }
                }
                else{
                    showCustomToast("Entered Email is invalid")
                }

            }
            else{
                showCustomToast("Empty fields are not allowed")
            }
        }
    }

    private fun showCustomToast(message: String) {

        val layoutInflater = LayoutInflater.from(this)
        val customToastBinding = ActivityCutomToastBinding.inflate(layoutInflater)

        customToastBinding.tvMessage.text = message

        with(Toast(this)) {
            duration = Toast.LENGTH_SHORT
            view = customToastBinding.root
            show()
        }
    }

}