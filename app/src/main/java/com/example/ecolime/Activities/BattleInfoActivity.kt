package com.example.ecolime.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecolime.R
import com.example.ecolime.databinding.ActivityBattleInfoBinding

class BattleInfoActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBattleInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBattleInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}