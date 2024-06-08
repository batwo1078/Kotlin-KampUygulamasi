package com.mrcaracal.havadurumumrc.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import com.google.android.material.navigation.NavigationView
import com.mrcaracal.havadurumumrc.R





class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anasayfa2)





        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)



        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {

                }

                R.id.nav_havadurumu -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_harita -> {
                    val intent = Intent(this, activity_harita::class.java)
                    startActivity(intent)
                }

                R.id.nav_pusula -> {
                    val intent = Intent(this, Activity_pusula::class.java)
                    startActivity(intent)
                }
                // R.id.nav_liste -> {
                //val intent = Intent(this,liste_activity ::class.java)
                //startActivity(intent)
                //  }
                R.id.nav_tarif -> {
                    val intent = Intent(this, Activity_yemek::class.java)
                    startActivity(intent)
                }

            }

            drawerLayout.closeDrawers()
            true
        }


        /* val hvdurumu_ac = findViewById<Button>(R.id.hvdurumu_ac)
        val haritaac = findViewById<Button>(R.id.haritaac)

        hvdurumu_ac.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        haritaac.setOnClickListener {
            val intent = Intent(this,activity_harita::class.java)
            startActivity(intent)
        }

        pusulaac.setOnClickListener {
            val intent = Intent(this,Activity_pusula ::class.java)
            startActivity(intent)
        }*/


        /* override fun onOptionsItemSelected(item: MenuItem): Boolean {

         if (toggle.onOptionsItemSelected(item)){
             return true
         }

         return super.onOptionsItemSelected(item)
     }*/


    }
}



