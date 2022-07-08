package com.example.ecolime

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.ecolime.Activities.BattleStrategyActivity
import com.example.ecolime.Model.User

class SharedPref(context: Context) {



    private val KEY_UID="uid"
    private val KEY_NAME="name"
    private val KEY_AVATAR="avatar"
    private val KEY_STRATEGY="strategy"
    private val KEY_EMAIL="email"
    private var sharedPreferences: SharedPreferences
    init {
        sharedPreferences=context.getSharedPreferences(context.packageName,MODE_PRIVATE)
    }

    fun updateStrategy(value:String)
    {
        val editor=sharedPreferences.edit()
        editor.putString(KEY_STRATEGY,value)
        editor.apply()
    }
    fun saveUser(user: User)
    {
        val editor=sharedPreferences.edit()
        editor.putString(KEY_EMAIL,user.email)
        editor.putString(KEY_NAME,user.username)
        editor.putString(KEY_UID,user.uid)
        editor.putString(KEY_AVATAR,user.avatar)
        editor.putString(KEY_STRATEGY,user.strategy.toString())
        editor.apply()

    }
    fun getUser():User
    {
        return User( sharedPreferences.getString(KEY_UID,"")!!,sharedPreferences.getString(KEY_NAME,"")!!, sharedPreferences.getString(KEY_EMAIL,"")!!
            , "",sharedPreferences.getString(KEY_AVATAR,"")!!,0, BattleStrategyActivity.BattleStrategy.valueOf(sharedPreferences.getString(KEY_STRATEGY,"")!!) )

    }


}