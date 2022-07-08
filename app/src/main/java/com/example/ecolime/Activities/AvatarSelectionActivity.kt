package com.example.ecolime.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.ecolime.Model.User
import com.example.ecolime.databinding.ActivityAvatarSelectionBinding

class AvatarSelectionActivity : AppCompatActivity(), View.OnClickListener {


    companion object{
        public val EXTRA_USER="User"
    }
    private lateinit var binding: ActivityAvatarSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding=ActivityAvatarSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        for (i in 0 until binding.gridLayout.childCount)
        {
            binding.gridLayout.getChildAt(i).setOnClickListener(this)
        }

    }

    override fun onClick(view: View?)
    {

        val imageName=view!!.tag as String
        val user=intent.extras!!.getSerializable(EXTRA_USER) as User
        user.avatar=imageName
        startActivity(Intent(this,BattleStrategyActivity::class.java).putExtra(BattleStrategyActivity.EXTRA_USER,user))

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}