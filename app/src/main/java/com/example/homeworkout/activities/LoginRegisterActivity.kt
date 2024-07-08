package com.example.homeworkout.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.Toast
import com.example.homeworkout.R
import com.example.homeworkout.databinding.ActivityCutomToastBinding
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
                                showCustomToast("Registration Failed. Please try again")
                            }
                        }
                    }
                    else{
                        binding.rgPassword.error = "Length of Password should be atleast 6"
                        binding.rgPassword.requestFocus()
                        return@setOnClickListener
//                        showCustomToast("Length of Password should be atleast 6")
                    }
                }
                else{
                    binding.rgEmail.error = "Entered Email is invalid"
                    binding.rgEmail.requestFocus()
                    return@setOnClickListener
//                    showCustomToast("Entered Email is invalid")
                }

            }
            else{
                if(email.isEmpty() && password.isEmpty()){
                    binding.rgPassword.error = "Empty fields are not allowed"
                    binding.rgEmail.error = "Empty fields are not allowed"
                    binding.rgPassword.requestFocus()
                    binding.rgEmail.requestFocus()
                    return@setOnClickListener
                }
                else if(email.isNotEmpty()){
                    binding.rgPassword.error = "Empty fields are not allowed"
                    binding.rgPassword.requestFocus()
                    return@setOnClickListener
                }
                else{
                    binding.rgEmail.error = "Empty fields are not allowed"
                    binding.rgEmail.requestFocus()
                    return@setOnClickListener
                }

//                showCustomToast("Empty fields are not allowed")
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

fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
