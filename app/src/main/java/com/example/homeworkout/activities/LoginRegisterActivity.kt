package com.example.homeworkout.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityLoginRegisterBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

//@AndroidEntryPoint
class LoginRegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var UID : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.rgSighIn.setOnClickListener {
            val  intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        val db = Firebase.firestore

        binding.btnRegister.setOnClickListener{
            val firstName = binding.rgFName.text.toString()
            val lastName = binding.rgLName.text.toString()
            val email = binding.rgEmail.text.toString().trim()
            val password = binding.rgPassword.text.toString()
            val user = hashMapOf(
                "fname" to firstName,
                "lname" to lastName,
                "email" to email
            )

            if(email.isNotEmpty() && password.isNotEmpty()){
                if(email.isValidEmail()){
                    if(password.length >=6){
                        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                            if(it.isSuccessful){
                                UID = firebaseAuth.uid.toString()

                                val userRef = db.collection("users").document(UID)
                                userRef.set(user)

                                val intent = Intent(this,SignInActivity::class.java)
                                startActivity(intent)
                            }
                            else{
                                Toast.makeText(this,it.exception.toString(),Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    else{
                        Toast.makeText(this,"Length of Password Should me greater than 5",Toast.LENGTH_LONG).show()
                    }
                }
                else{
                    Toast.makeText(this,"Invalid Email",Toast.LENGTH_LONG).show()
                }

            }
            else{
                Toast.makeText(this,"Empty Fields are not allowed",Toast.LENGTH_LONG).show()
            }
        }
    }
}

fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
