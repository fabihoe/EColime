package com.example.ecolime.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SwitchCompat
import com.example.ecolime.Interface.MessageListener
import com.example.ecolime.Util
import com.example.ecolime.databinding.ActivityGreenCertBinding

class GreenCertActivity : AppCompatActivity() {


    private lateinit var binding:ActivityGreenCertBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding=ActivityGreenCertBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnMoreInfo.setOnClickListener {
            startActivity(Intent(this,BattleInfoActivity::class.java))
        }
        binding.switch1.setOnCheckedChangeListener { compoundButton, b ->

            if(b)
            {
                binding.progressBar1.progress=100
                binding.progressBar2.progress=0
                binding.switch2.isChecked=false
                confirm(    binding.switch1,"Are you Sure to select full compensation ? ",3)
            }

        }
        binding.switch2.setOnCheckedChangeListener { compoundButton, b ->

            if(b)
            {
                binding.switch1.isChecked=false
                binding.progressBar2.progress=50
                binding.progressBar1.progress=0
                confirm(    binding.switch2,"Are you Sure to select 50% compensation ? ",1)
            }

        }

    }

    private fun confirm(switch: SwitchCompat,message:String, coins: Int)
    {
        Util.showMessageDialog(this, message, object :
            MessageListener {
            override fun onSelected(isYesSelected: Boolean) {

                if (isYesSelected)
                {

                    finish()
                    startActivity(Intent(this@GreenCertActivity,CoinEarnedActivity::class.java).putExtra(CoinEarnedActivity.EXTRA_COIN,coins))
                }
                else
                {
                    binding.progressBar1.progress=0
                    binding.progressBar2.progress=0
                    switch.isChecked=false
                }
            }
        })
    }
}