package com.example.homeworkout.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworkout.databinding.ActivityForgetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetPasswordBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.backButton.setOnClickListener{
            val intent  = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.buttonResetPassword.setOnClickListener {
            val email = binding.edEmailLogin.text.toString().trim()
            if (email.isEmpty()) {
                binding.edEmailLogin.error = "Email is required"
                binding.edEmailLogin.requestFocus()
                return@setOnClickListener
            }

            resetPassword(email)
        }

    }


    private fun resetPassword(email: String) {
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Check your email to reset your password", Toast.LENGTH_LONG)
                    .show()
                val intent  = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Failed to send reset email", Toast.LENGTH_LONG).show()
            }
        }
    }
}