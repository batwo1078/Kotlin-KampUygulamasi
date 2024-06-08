package com.mrcaracal.havadurumumrc.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mrcaracal.havadurumumrc.R
import com.mrcaracal.havadurumumrc.databinding.ActivityHaritaBinding
import java.util.*

class activity_harita : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityHaritaBinding
    private  lateinit var locationmanager : LocationManager
    private lateinit var locationlistener : LocationListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHaritaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        locationmanager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationlistener = object : LocationListener {
            @RequiresApi(Build.VERSION_CODES.TIRAMISU)
            override fun onLocationChanged(p0: Location) {
                //lokasyon, konum değişince yapılacak işlemler
                //println(p0.latitude)
                //println(p0.longitude)

                mMap.clear()
                val guncelKonum = LatLng(p0.latitude, p0.longitude)
                mMap.addMarker(MarkerOptions().position(guncelKonum).title("Konunumunuz"))
                //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(guncelKonum, 15f))


                val geocoder = Geocoder(this@activity_harita, Locale.getDefault())


                try {

                    fun Geocoder.getAddress(
                        latitude: Double,
                        longitude: Double,
                        address: (android.location.Address?) -> Unit
                    ) {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            val adresListesi = geocoder.getFromLocation(p0.latitude, p0.longitude, 1) { address(it.firstOrNull()) }

                            return

                        }

                    }



                }catch (e : Exception) {
                    e.printStackTrace()
                }



            }

        }


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            //İZİN VERİLMEMİŞ
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),1)

        } else {
            //izin verilmiş
            locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1,1f, locationlistener)
            val sonBilinenKonum = locationmanager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (sonBilinenKonum != null) {

                val sonBilinenLatLang = LatLng(sonBilinenKonum.latitude,sonBilinenKonum.longitude)
                mMap.addMarker(MarkerOptions().position(sonBilinenLatLang).title("Son Konumunuz"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sonBilinenLatLang,15f))
            }


        }

    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1){
            if (grantResults.size > 0){
                if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED )
                //izin verildi
                    locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1,1f, locationlistener)

            }
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }



}