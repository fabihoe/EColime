package com.example.ecolime.Activities

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.ecolime.R
import com.example.ecolime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{


    private lateinit var captions: List<String>
    private lateinit var binding: ActivityMainBinding
    private var index=0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        captions =arrayOf(getString(R.string.caption_1),getString(R.string.caption_2)).toList()

        object : CountDownTimer(2000, 1000)
        {
            override fun onTick(l: Long)
            {

                binding.progressBar.progress=(index+1)
                binding.txtCaption.text=captions[index++]

            }
            override fun onFinish() {

                finish()
                startActivity(Intent(this@MainActivity,LoginActivity::class.java))

            }
        }.start()

    }
}