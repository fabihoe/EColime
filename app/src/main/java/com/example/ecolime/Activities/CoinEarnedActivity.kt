package com.example.ecolime.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.TypedArrayUtils.getResourceId
import com.example.ecolime.Model.User
import com.example.ecolime.R
import com.example.ecolime.SharedPref
import com.example.ecolime.databinding.ActivityCoinEarnedBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firestore.v1.Value

class CoinEarnedActivity : AppCompatActivity() {

    companion object{
       const val EXTRA_COIN :String ="coin"
    }
    private  var coins_earned=0L

    private lateinit var binding:ActivityCoinEarnedBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCoinEarnedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        coins_earned=intent.extras!!.getInt(EXTRA_COIN,0).toLong()
        val user=SharedPref(this).getUser()


        binding.txtCoinsEarned.text="$coins_earned coins earned!"
        binding.txtUserName.text=user.username
        val res_id=resources.getIdentifier(user.avatar, "drawable", packageName);
        binding.imgUser.setImageResource(res_id)
        binding.btnFriendsCoin.setOnClickListener {
            startActivity(Intent(this,FriendsCoinsActivity::class.java))
        }
        updateInFirebase()
    }

    @SuppressLint("SetTextI18n")
    private fun updateInFirebase() {
        Firebase.firestore.collection("Users").document(FirebaseAuth.getInstance().currentUser!!.uid).update("coins",FieldValue.increment(coins_earned)).addOnCompleteListener {
            if(it.isSuccessful)
            {
                Firebase.firestore.collection("Users").document(FirebaseAuth.getInstance().currentUser!!.uid).get().addOnCompleteListener {

                    if(it.isSuccessful)
                    {
                        val user=it.result.toObject(User::class.java)
                        binding.txtTotalCoins.text="${user!!.coins} Coins"
                    }
                }
            }
        }
    }
}