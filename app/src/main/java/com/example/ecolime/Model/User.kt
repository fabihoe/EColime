package com.example.ecolime.Model

import com.example.ecolime.Activities.BattleStrategyActivity.BattleStrategy
import java.io.Serializable

data class User(var uid:String,var username:String,var email:String,var pass:String,var avatar:String,var coins:Int,var strategy: BattleStrategy):Serializable
{
    constructor() : this("","","","","",0,BattleStrategy.SHOCK_AND_AWE) {

    }
}