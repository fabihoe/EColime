package com.example.ecolime.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ecolime.Model.User
import com.example.ecolime.R
import com.example.ecolime.Util
import com.example.ecolime.databinding.ActivityLoginBinding
import com.example.ecolime.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener(this)
        binding.txtSign.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        if(view==binding.btnCreateAccount)
        {
            if(isValid())
            {
                authenticate()
            }
        }
        if(view==binding.txtSign)
        {
            finish()
        }
    }

    private fun authenticate()
    {

        val name=binding.inputLayoutName.editText!!.text.toString().trim()
        val email=binding.inputLayoutEmail.editText!!.text.toString().trim()
        val password=binding.inputLayoutPassword.editText!!.text.toString()
        val user=User("",name,email,password,"",0,BattleStrategyActivity.BattleStrategy.SHOCK_AND_AWE)
        startActivity(Intent(this,AvatarSelectionActivity::class.java).putExtra(AvatarSelectionActivity.EXTRA_USER,user))


    }

    private fun isValid(): Boolean
    {

        if(Util.isEmpty(binding.inputLayoutEmail,binding.inputLayoutName,binding.inputLayoutPassword))
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

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}