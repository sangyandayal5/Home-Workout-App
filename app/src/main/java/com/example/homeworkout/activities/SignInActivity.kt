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
                                Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    else{
                        showCustomToast("The password is too short")
//                        Toast.makeText(this,"Length of Password Should me greater than 5", Toast.LENGTH_LONG).show()
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

    private fun showCustomToast(message: String) {
        // Inflate custom toast layout
        val layoutInflater = LayoutInflater.from(this)
        val customToastBinding = ActivityCutomToastBinding.inflate(layoutInflater)

        // Set the message for the custom toast
        customToastBinding.tvMessage.text = message

        // Create the toast
        with(Toast(this)) {
            duration = Toast.LENGTH_SHORT
            view = customToastBinding.root
            show()
        }
    }

}