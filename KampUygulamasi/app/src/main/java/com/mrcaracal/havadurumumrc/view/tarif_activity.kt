package com.mrcaracal.havadurumumrc.view

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.mrcaracal.havadurumumrc.R
import kotlinx.android.synthetic.main.activity_pusula2.*
import kotlinx.android.synthetic.main.activity_tarif.*

class tarif_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarif)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        // NavigationView'daki tıklamaları işleme al
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this,SecondActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_havadurumu -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_harita -> {
                    val intent = Intent(this,activity_harita::class.java)
                    startActivity(intent)
                }
                R.id.nav_pusula -> {
                    val intent = Intent(this,Activity_pusula ::class.java)
                    startActivity(intent)
                }
               // R.id.nav_liste -> {
                   // val intent = Intent(this,liste_activity ::class.java)
                   // startActivity(intent)
              //  }
                R.id.nav_tarif -> {
                    val intent = Intent(this,Activity_yemek ::class.java)
                    startActivity(intent)
                }

            }
            // Drawer'ı kapat
            drawerLayout.closeDrawers()
            true
        }

        geribtn2.setOnClickListener{
            finish()
        }




        val intent = intent
        val secilenyemek = intent.getStringExtra("tarifisim")
        textView2.text = secilenyemek

        val yemektarifi = intent.getStringExtra("tarif")
        textView5.text = yemektarifi

       val secilengorsel = intent.getIntExtra("yemekgorsel",0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,secilengorsel)
        imageView4.setImageBitmap(bitmap)





    }








}