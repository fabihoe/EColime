package com.example.ecolime.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ecolime.Model.User
import com.example.ecolime.R
import com.example.ecolime.SharedPref
import com.example.ecolime.Util
import com.example.ecolime.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener(this)
        binding.txtCreateAccount.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        if(view==binding.btnSignIn)
        {
            if(isValid())
            {
                authenticate()
            }
        }
        if(view==binding.txtCreateAccount)
        {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }

    private fun authenticate()
    {

        val progressDialog=Util.getProgressDialog(this,true)
        val email=binding.inputLayoutEmail.editText!!.text.toString().trim()
        val password=binding.inputLayoutPassword.editText!!.text.toString()
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {


                if(it.isSuccessful)
                {

                    Firebase.firestore.collection("Users")
                        .document(FirebaseAuth.getInstance().currentUser!!.uid)
                        .get().addOnCompleteListener { it1 ->
                            progressDialog.dismiss()
                            if(it1.isSuccessful)
                            {


                                finish()
                                val user=it1.result.toObject(User::class.java)
                                SharedPref(this).saveUser(user!!)
                                startActivity(Intent(this,MapsActivity::class.java))
                            }
                            else
                            {
                                Util.showMessage(this,it1.exception?.message)
                            }

                        }

                }
                else
                {
                    progressDialog.dismiss()
                    Util.showMessage(this,it.exception?.message)
                }

            }

    }

    private fun isValid(): Boolean
    {

        if(Util.isEmpty(binding.inputLayoutEmail,binding.inputLayoutPassword))
        {
            return false
        }
        if(!Util.isValidEmail(binding.inputLayoutEmail.editText!!.text.toString()))
        {
            binding.inputLayoutEmail.error="Invalid Email"
            return false
        }
        if(binding.inputLayoutPassword.editText!!.text.toString().length<6)
        {
            binding.inputLayoutPassword.error="Password must be of at least 6 digits"
            return false
        }

        return true
    }
}