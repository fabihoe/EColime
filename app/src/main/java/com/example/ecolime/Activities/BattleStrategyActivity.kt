package com.example.ecolime.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.ecolime.Model.User
import com.example.ecolime.R
import com.example.ecolime.SharedPref
import com.example.ecolime.Util
import com.example.ecolime.databinding.ActivityBattleStrategyBinding
import com.example.ecolime.fragments.BattleStrategyFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BattleStrategyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBattleStrategyBinding

    enum class BattleStrategy
    {
        SHOCK_AND_AWE,DEFEAT_IN_DETAIL,DECEPTION
    }
    enum class Actions
    {
        NEW_USER,EDIT_STRATEGY
    }
    companion object{
        public val EXTRA_USER="User"
        public val EXTRA_ACTION="action"
    }
    private lateinit var user: User
    private lateinit var action: Actions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBattleStrategyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras=intent.extras!!
        if(extras.containsKey(EXTRA_ACTION))
            action=Actions.valueOf(extras.getString(EXTRA_ACTION,"NEW_USER"))

        if(extras.containsKey(EXTRA_USER))
            user=extras.getSerializable(AvatarSelectionActivity.EXTRA_USER) as User

        binding.viewpager.adapter=ScreenSlidePagerAdapter(supportFragmentManager,this)
        binding.tabLayout.setupWithViewPager( binding.viewpager,true)

    }

    public fun onStrategySelected(strategy: BattleStrategy)
    {
        saveUserInfo(strategy)
    }

    private fun saveUserInfo(strategy: BattleStrategy)
    {
       if(::user.isInitialized)
             user.strategy=strategy

        val progressDialog=Util.getProgressDialog(this,true)
        if(action==Actions.EDIT_STRATEGY)
        {
            val db = Firebase.firestore
            db.collection("Users").document(  FirebaseAuth.getInstance().currentUser!!.uid).update("strategy",strategy.toString()).addOnCompleteListener {
                progressDialog.dismiss()
                if(it.isSuccessful)
                {
                    ActivityCompat.finishAffinity(this)
                    SharedPref(this).updateStrategy(strategy.toString())
                    startActivity(Intent(this,MapsActivity::class.java))
                }
                else
                {

                    Util.showMessage(this,it.exception?.message)
                }
            }

        }
        else
        {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(user.email,user.pass)
                .addOnCompleteListener {

                    if(it.isSuccessful)
                    {
                        val db = Firebase.firestore
                        user.uid=FirebaseAuth.getInstance().currentUser!!.uid
                        db.collection("Users").document(  user.uid).set(user).addOnCompleteListener {

                            progressDialog.dismiss()
                            if(it.isSuccessful)
                            {
                                ActivityCompat.finishAffinity(this)
                                SharedPref(this).saveUser(user)
                                startActivity(Intent(this,MapsActivity::class.java))
                            }
                            else
                            {

                                Util.showMessage(this,it.exception?.message)
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


    }

    class ScreenSlidePagerAdapter(fm: FragmentManager,val context:Context) : FragmentStatePagerAdapter(fm)
    {
        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment
        {
            return when (position) {
                0 -> {
                    BattleStrategyFragment.newInstance(context.getString(R.string.battle_strategy_title1),context.getString(R.string.battle_strategy_desc1),R.drawable.battle_strategy_img1,BattleStrategy.SHOCK_AND_AWE)
                }
                1 -> {
                    BattleStrategyFragment.newInstance(context.getString(R.string.battle_strategy_title2),context.getString(R.string.battle_strategy_desc2),R.drawable.battle_strategy_img2,BattleStrategy.DEFEAT_IN_DETAIL)
                }
                2 -> {
                    BattleStrategyFragment.newInstance(context.getString(R.string.battle_strategy_title3),context.getString(R.string.battle_strategy_desc3),R.drawable.battle_strategy_img3,BattleStrategy.DECEPTION)
                }
                else -> {
                    BattleStrategyFragment.newInstance(context.getString(R.string.battle_strategy_title1),context.getString(R.string.battle_strategy_desc1),R.drawable.battle_strategy_img1,BattleStrategy.SHOCK_AND_AWE)
                }
            }
         }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}