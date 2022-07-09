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




    fun getDummyData():List<Data>
    {
         val listData:MutableList<Data> = ArrayList()
        listData.add(Data(latlng = "48.137154,11.576124", price = 0.49))
        listData.add(Data(latlng = "48.138974,11.578547", price = 0.47))
        listData.add(Data(latlng = "48.137842,11.583178", price = 0.46))
        listData.add(Data(latlng = "48.135517,11.571345", price = 0.26, isPrivate = true, name = "Rudy Haywood", avatar = "ic_avatar_1"))
        listData.add(Data(latlng = "48.139447,11.571926", price = 0.28, isPrivate = true, name = "Deidra Ayres", avatar = "ic_avatar_2"))
        listData.add(Data(latlng = "48.137085,11.584214", price = 0.29, isPrivate = true, name = "Chance Marlow", avatar = "ic_avatar_3"))

        return listData
    }
}