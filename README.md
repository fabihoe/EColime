# Technical Report

## ****Things used in this project****

### ****Software:****

Figma: [https://www.figma.com](https://www.figma.com/)

Android Studio: [https://developer.android.com/studio](https://developer.android.com/studio)

Firebase: [https://firebase.google.com](https://firebase.google.com/)

## Our Story

We are students of the Technical University of Munich, who created the app “Ecolime” as part of the tech challenge in summer semester 2022. With the app, we want to encourage sustainable driving patterns and share our vision of the future of green EV charging. This guide describes the process of creating Ecolime.

Currently, many EV charging stations are not only comparatively expensive but are also powered by electricity from non-renewable sources. At the same time, however, an immense amount of renewable energy is being destroyed. To illustrate this point consider a company with solar panels on their office building. Over the weekend the energy is either not used at all or fed into the grid for little money. With Ecolime, we are demonstrating an approach that attempts to counteract this inefficiency. The app enables companies and individuals to sell their surplus energy from renewable sources to EV drivers in a smart way, while simultaneously generating higher revenue than the compensation received for feeding it back into the grid . 

Our target group primarily consists of early adopters with strong environmental awareness and the need to charge without CO2 emissions. In addition, we are targeting frugal EV drivers as the surplus energy offered by private homeowners and companies is sold at a lower price compared to public charging stations. In the beginning, early adopters will have to drive to the providers and charge on site. In the future, it is envisioned that municipalities will build their own smart grids transporting renewable energy within the municipality and enabling EV drivers to charge their cars with surplus energy conveniently at home. 

The app encourages EV drivers to use surplus energy with gamification. Each time our customers charge green, they collect coins which can be redeemed at participating restaurants and stores. If it is not possible to charge at a green station or another station is more convenient for the customer, there is the possibility of compensating CO2 emissions while also earning coins. 

At the end of every charging process, users can view a ranking showing other users and their total coin balance. The amount of total coins reflects the number of completed sustainable charging cycles. 

## Building Ecolime

### Before Starting to Prototype

Before getting started on the prototype, we thought about the requirements our app must fulfill. We knew that our app would require an appealing user interface with good user experience in order to be embraced by users. 

Most notably:

- The app had to be self-explanatory so that users could find their way through the app immediately.
- The app had to be without major distractions.
- It had to be usable by anyone (no matter the age or technical affinity).

We downloaded and looked at numerous other apps from a wide variety of fields, i.e., not only apps in the realm of eMobility. The goal was to gather inspiration for the design and prototyping process. Regarding UX/UI and a pleasant aesthetic, we also looked at: 

- How are the buttons arranged?
- Do buttons have rounded corners?
- Which colors harmonize?
- Which fonts are pleasant to the eye?

### Demonstration of functionality through overview of screenshots

Below you can find an overview of all our screenshots in Figma:

<iframe style="border: 1px solid rgba(0, 0, 0, 0.1);" width="800" height="450" src="https://www.figma.com/embed?embed_host=share&url=https%3A%2F%2Fwww.figma.com%2Ffile%2FTGMzaKv2j2jgP4PJL9fwwA%2FEcolime%3Fnode-id%3D0%253A1" allowfullscreen></iframe>

To facilitate the understanding of the app functionalities the different screenshots are explained in more detail down below.

### Launch Screen

![launch screen 3.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/launch_screen_3.png)

After opening the app, the user will find various educational messages on the subject of climate change and sustainability appear during the loading process. The aim is to make EV drivers more motivated to charge completely emission-free.

### Login Screen

![login with email.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/login_with_email.png)

The user is asked to register with his/her name, e-mail address, age, vehicle and password before the first login. After the first registration, the user can log in with his e-mail address and password.

### Avatar Screen

![avatar.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/avatar.png)

After the first login, the user is asked to choose an avatar to his/ her liking. This should help to enable greater individualization in line with our goal of gamification.

### Different Battle Strategies

The user can choose different "battle strategies". This is our way of providing different charging options to the users. Our customers can choose whether they only want to see charging stations operating on 100% renewable energy, they are interested in offsetting emissions for charging stations not powered by renewable energy or whether they want to see all charging options without compensation payments. We have deliberately chosen to call the different charging options/modes "battle strategies" in order to get the user in the mood for a "battle" against climate change in which he can make an important contribution. This achieves further gamification of our application. Such themes are successfully used in numerous games for motivating players to get more involved in the game and its cause (in our case, fighting climate change).

![charging option.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/charging_option.png)

***Shock and Awe***

Users who select this strategy will only see charging stations that are powered by 100% renewable energy. Since it is difficult to identify the source of the electricity powering public charging stations, we assumed at the beginning of the project that only charging stations powered by surplus energy meet this criterion. These charging stations are often offered by companies or private individuals with solar panels on their roofs.

![charging option 2.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/charging_option_2.png)

***Defeat in Detail***

By choosing this option all charging stations are displayed, i.e. also public charging stations powered by electricity from non-renewable sources. If the user charges at a public charging station, however, he is shown the option of offsetting the CO2 emissions generated. This process is explained further down below.

![charging option 3.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/charging_option_3.png)

***Deception***

The last strategy is for users who want to explore all charging options without offsetting payments to compensate for charging CO2 emissions generated when using public charging options.

### Map with Charging Stations

![map_1.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/map_1.png)

On the map, charging stations of companies or private individuals powered by surplus energy are displayed with an avatar, while regular public charging stations are displayed without an avatar. The user can initiate a charging process by tapping on the charging station or the avatar.

### Compensation of CO2 emissions with offsetting payments

![green_cert_1.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/green_cert_1.png)

![green_cert_4.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/green_cert_4.png)

![green_cert_2.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/green_cert_2.png)

This is displayed when the user selected the "Defeat in Detail" strategy and used a public charging station powered by electricity from non-renewable sources. As depicted in the screenshots, the user has the option to offset 100% or 50% of the CO2 emissions generated during the charging process. Yet, this is not a required payment and will only be charged if the user agrees to it. However, keep in mind that the user only receives coins for their charging process if the emissions have been compensated or the electricity comes from renewable sources.

### Coins earned

![coins earned.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/coins_earned.png)

After charging at charging stations powered by surplus energy, the user receives 5 coins. If the user has charged at a public charging station powered by non-renewable energy and compensates 100% of the generated CO2 emissions, they receive 3 coins. In case the 50% compensation option is chosen, 1 coin gets awarded. These credits can be redeemed at participating restaurants and stores. To further improve the app’s gamification there is a ranking, whereby users can compare themselves with their peers. 

### Ranking Screen

![ranking.png](Technical%20Report%209827485f14ec44ea8fb751b89a432919/ranking.png)

The ranking allows the individual users to see how many coins they have already collected compared to their peers. This feature is a key gamification element and intended to encourage users to charge "greener" than their peers.

## Important Features in Code

### Launch Screen

```kotlin
package com.example.ecolime.Activities

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.ecolime.R
import com.example.ecolime.databinding.ActivityMainBinding

//LAUNCH SCREEN

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
```

### Map

```kotlin
package com.example.ecolime.Activities

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ecolime.Model.Data
import com.example.ecolime.Model.User
import com.example.ecolime.R
import com.example.ecolime.SharedPref
import com.example.ecolime.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var  user:User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user=SharedPref(this).getUser()
        binding=ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment=supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        binding.btnChangeStrategy.setOnClickListener {
            startActivity(Intent(this@MapsActivity,BattleStrategyActivity::class.java).putExtra(BattleStrategyActivity.EXTRA_ACTION,BattleStrategyActivity.Actions.EDIT_STRATEGY.toString()))

        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap=googleMap
//check which strategy the user selected in order to show the appropriate charging stations
        for(data in getDummyData())
        {

            if(user.strategy==BattleStrategyActivity.BattleStrategy.SHOCK_AND_AWE && !data.isPrivate)
            {
                continue
            }
            val marker=mMap.addMarker(MarkerOptions().position(getLatLng(data.latlng)).icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(data)!!)))
            marker!!.tag=data.isPrivate
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(getLatLng(data.latlng),14f))

        }

        mMap.setOnMarkerClickListener(object :GoogleMap.OnMarkerClickListener
        {
            override fun onMarkerClick(it: Marker): Boolean {

                if(it.tag as Boolean)
                {
                    startActivity(Intent(this@MapsActivity,CoinEarnedActivity::class.java).putExtra(CoinEarnedActivity.EXTRA_COIN,3))
                    return true
                }
                if(user.strategy==BattleStrategyActivity.BattleStrategy.DEFEAT_IN_DETAIL)
                {
                    startActivity(Intent(this@MapsActivity,GreenCertActivity::class.java))
                    return true
                }
                startActivity(Intent(this@MapsActivity,CoinEarnedActivity::class.java).putExtra(CoinEarnedActivity.EXTRA_COIN,0))
                 return true
            }

        })
    }

    private fun getLatLng(latlng: String): LatLng
    {
        val lat=latlng.split(",")[0].toDouble()
        val lng=latlng.split(",")[1].toDouble()
        return LatLng(lat,lng)
    }

    private fun getMarkerBitmapFromView(data:Data): Bitmap? {
        val customMarkerView=(getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.lyt_map_snippet, null)

        val avatar = customMarkerView.findViewById<ImageView>(R.id.avatarImage);
        val txtPersonName=customMarkerView.findViewById<TextView>(R.id.txtPersonName)
        val txtPrice=customMarkerView.findViewById<TextView>(R.id.txtPrice)

        if(data.isPrivate)
        {
            val res_id=resources.getIdentifier(data.avatar, "drawable", packageName);
            avatar.setImageResource(res_id)
            txtPersonName.text=data.name
        }
        else
        {
            txtPersonName.text="Charging Station"
            avatar.visibility=View.GONE
        }

        txtPrice.text="price: ${data.price} €"
        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        customMarkerView.layout(0,
            0,
            customMarkerView.measuredWidth,
            customMarkerView.measuredHeight
        )
        customMarkerView.buildDrawingCache()
        val returnedBitmap=
            Bitmap.createBitmap(customMarkerView.measuredWidth, customMarkerView.measuredHeight,
                Bitmap.Config.ARGB_8888
            )
        val canvas=Canvas(returnedBitmap)
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN)
        val drawable=customMarkerView.background
        drawable?.draw(canvas)
        customMarkerView.draw(canvas)
        return returnedBitmap
    }

//Dummy Charging Stations 
    fun getDummyData():List<Data>
    {
         val listData:MutableList<Data> = ArrayList()
        listData.add(Data(latlng = "48.137154,11.576124", price = 0.49))
        listData.add(Data(latlng = "48.138974,11.578547", price = 0.47))
        listData.add(Data(latlng = "48.137842,11.583178", price = 0.46))
        listData.add(Data(latlng = "48.135517,11.571345", price = 0.19, isPrivate = true, name = "Rudy Haywood", avatar = "ic_avatar_1"))
        listData.add(Data(latlng = "48.139447,11.571926", price = 0.20, isPrivate = true, name = "Deidra Ayres", avatar = "ic_avatar_2"))
        listData.add(Data(latlng = "48.137085,11.584214", price = 0.22, isPrivate = true, name = "Chance Marlow", avatar = "ic_avatar_3"))

        return listData
    }
}
```

### Battle Strategies

```kotlin
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

//BATTLE STRATEGIES

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

    public fun onStrategySelected(strategy: BattleStrategy) //selection of battles strategy/ charging option 
    {
        saveUserInfo(strategy)
    }

    private fun saveUserInfo(strategy: BattleStrategy) //choice saved
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
```

### Green Certificate

```kotlin
package com.example.ecolime.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SwitchCompat
import com.example.ecolime.Interface.MessageListener
import com.example.ecolime.Util
import com.example.ecolime.databinding.ActivityGreenCertBinding

//GREEN CERTIFICATE

class GreenCertActivity : AppCompatActivity() {

    private lateinit var binding:ActivityGreenCertBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding=ActivityGreenCertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMoreInfo.setOnClickListener {
            startActivity(Intent(this,BattleInfoActivity::class.java))     //further information on what choosing a CO2 fighter means
        }
        binding.switch1.setOnCheckedChangeListener { compoundButton, b ->

            if(b) //choosing full compensation
            {
                binding.progressBar1.progress=100
                binding.progressBar2.progress=0
                binding.switch2.isChecked=false
                confirm(    binding.switch1,"Are you Sure to select full compensation ? ",3)
            }

        }
        binding.switch2.setOnCheckedChangeListener { compoundButton, b ->

            if(b) //choosing 50% compensation
            {
                binding.switch1.isChecked=false
                binding.progressBar2.progress=50
                binding.progressBar1.progress=0
                confirm(    binding.switch2,"Are you Sure to select 50% compensation ? ",1)
            }

        }

    }

    private fun confirm(switch: SwitchCompat,message:String, coins: Int) //confirm selection 
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
```

## Final Remarks

This app project was developed under time constrains. Therefore, no fully functioning product can be provided. The source code is only supposed to demonstrate key features.

## Credits

Fabian Hönes: fabian.hoenes@tum.de

Maria Lipovenko: maria.lipovenko@tum.de

Jasmin Steinbrecher: jasmin.steinbrecher@tum.de
