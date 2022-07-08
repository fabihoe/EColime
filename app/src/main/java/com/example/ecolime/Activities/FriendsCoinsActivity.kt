package com.example.ecolime.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecolime.Adapter.FriendsCoinAdapter
import com.example.ecolime.Model.User
import com.example.ecolime.R
import com.example.ecolime.SharedPref
import com.example.ecolime.Util
import com.example.ecolime.databinding.ActivityFriendsCoinsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FriendsCoinsActivity : AppCompatActivity() {

    private lateinit var users:MutableList<User>
    private lateinit var friendsCoinAdapter: FriendsCoinAdapter
    private lateinit var binding:ActivityFriendsCoinsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFriendsCoinsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        users= ArrayList()

        val user=SharedPref(this).getUser()
        friendsCoinAdapter=FriendsCoinAdapter(users,this)
        binding.recyclerView.adapter=friendsCoinAdapter
        val res_id=resources.getIdentifier(user.avatar, "drawable", packageName);
        binding.imgUser.setImageResource(res_id)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        loadData()
    }

    private fun loadData() {
        val progressDialog=Util.getProgressDialog(this, true)
        val db=Firebase.firestore

        db.collection("Users").orderBy("coins",Query.Direction.DESCENDING).get().addOnCompleteListener {

            progressDialog.dismiss()
            if(it.isSuccessful)
            {
                users.clear()
                val docs=it.result.documents
                for(doc in docs)
                {
                    users.add(doc.toObject(User::class.java)!!)
                }
                friendsCoinAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}