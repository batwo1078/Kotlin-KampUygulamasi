package com.mrcaracal.havadurumumrc.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.mrcaracal.havadurumumrc.R
import kotlinx.android.synthetic.main.activity_liste.*
import kotlinx.android.synthetic.main.activity_yemek.*

class liste_activity : AppCompatActivity() {


    private lateinit var sharedPreferences: SharedPreferences

    private var miktar1 = 0
    private var miktar2 = 0
    private var miktar3 = 0
    private var miktar4 = 0
    private var miktar5 = 0
    private var miktar6 = 0
    private var miktar7 = 0
    private var miktar8 = 0
    private var miktar9 = 0
    private var miktar10 = 0

    private lateinit var txturun: EditText
    private lateinit var txturun2: EditText
    private lateinit var txturun4: EditText
    private lateinit var txturun5: EditText
    private lateinit var txturun6: EditText
    private lateinit var txturun7: EditText
    private lateinit var txturun8: EditText
    private lateinit var txturun9: EditText
    private lateinit var txturun10: EditText
    private lateinit var txturun11: EditText





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        miktar1 = sharedPreferences.getInt("miktar1", 0)
        miktar2 = sharedPreferences.getInt("miktar2", 0)
        miktar3 = sharedPreferences.getInt("miktar3", 0)
        miktar4 = sharedPreferences.getInt("miktar4", 0)
        miktar5 = sharedPreferences.getInt("miktar5", 0)
        miktar6 = sharedPreferences.getInt("miktar6", 0)
        miktar7 = sharedPreferences.getInt("miktar7", 0)
        miktar8 = sharedPreferences.getInt("miktar8", 0)
        miktar9 = sharedPreferences.getInt("miktar9", 0)
        miktar10 = sharedPreferences.getInt("miktar10", 0)

        txturun = findViewById(R.id.txturun)
        txturun2 = findViewById(R.id.txturun2)
        txturun4 = findViewById(R.id.txturun4)
        txturun5 = findViewById(R.id.txturun5)
        txturun6 = findViewById(R.id.txturun6)
        txturun7 = findViewById(R.id.txturun7)
        txturun8 = findViewById(R.id.txturun8)
        txturun9 = findViewById(R.id.txturun9)
        txturun10 = findViewById(R.id.txturun10)



        txturun.setText(sharedPreferences.getString("urun1", ""))
        txturun2.setText(sharedPreferences.getString("urun2", ""))
        txturun4.setText(sharedPreferences.getString("urun3", ""))
        txturun5.setText(sharedPreferences.getString("urun4", ""))
        txturun6.setText(sharedPreferences.getString("urun5", ""))
        txturun7.setText(sharedPreferences.getString("urun6", ""))
        txturun8.setText(sharedPreferences.getString("urun7", ""))
        txturun9.setText(sharedPreferences.getString("urun8", ""))
        txturun10.setText(sharedPreferences.getString("urun9", ""))
        txturun11.setText(sharedPreferences.getString("urun10", ""))



        miktarGuncelle(1)
        miktarGuncelle(2)
        miktarGuncelle(3)
        miktarGuncelle(4)
        miktarGuncelle(5)
        miktarGuncelle(6)
        miktarGuncelle(7)
        miktarGuncelle(8)
        miktarGuncelle(9)
        miktarGuncelle(10)

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
                    //val intent = Intent(this,liste_activity ::class.java)
                    //startActivity(intent)
               // }
                R.id.nav_tarif -> {
                    val intent = Intent(this,Activity_yemek ::class.java)
                    startActivity(intent)
                }

            }
            // Drawer'ı kapat
            drawerLayout.closeDrawers()
            true
        }

        geribtn4.setOnClickListener{
            finish()
        }


        btnarttır.setOnClickListener {
            miktarArttır(1)
        }
        btnazalt.setOnClickListener {
            miktarAzalt(1)
        }
        btnarttır2.setOnClickListener {
            miktarArttır(2)
        }
        btnazalt2.setOnClickListener {
            miktarAzalt(2)
        }
        btnarttır4.setOnClickListener {
            miktarArttır(3)
        }
        btnazalt4.setOnClickListener {
            miktarAzalt(3)
        }
        btnarttır5.setOnClickListener {
            miktarArttır(4)
        }
        btnazalt5.setOnClickListener {
            miktarAzalt(4)
        }
        btnarttır6.setOnClickListener {
            miktarArttır(5)
        }
        btnazalt6.setOnClickListener {
            miktarAzalt(5)
        }
        btnarttır7.setOnClickListener {
            miktarArttır(6)
        }
        btnazalt7.setOnClickListener {
            miktarAzalt(6)
        }
        btnarttır8.setOnClickListener {
            miktarArttır(7)
        }
        btnazalt8.setOnClickListener {
            miktarAzalt(7)
        }
        btnarttır9.setOnClickListener {
            miktarArttır(8)
        }
        btnazalt9.setOnClickListener {
            miktarAzalt(8)
        }
        btnarttır10.setOnClickListener {
            miktarAzalt(9)
        }
        btnazalt10.setOnClickListener {
            miktarAzalt(9)
        }
        btnarttır11.setOnClickListener {
            miktarAzalt(10)
        }
        btnazalt11.setOnClickListener {
            miktarAzalt(10)
        }

    }

    private fun miktarArttır(urunNo: Int){
        when(urunNo){
            1 -> miktar1++
            2 -> miktar2++
            3 -> miktar3++
            4 -> miktar4++
            5 -> miktar5++
            6 -> miktar6++
            7 -> miktar7++
            8 -> miktar8++
            9 -> miktar9++
            10 -> miktar10++
            else -> return
        }
        miktarGuncelle(urunNo)

    }
    private fun miktarAzalt(urunNo: Int){
        when(urunNo){
            1 -> if (miktar1 >= 1) miktar1--
            2 -> if (miktar2 >= 1) miktar2--
            3 -> if (miktar3 >= 1) miktar3--
            4 -> if (miktar4 >= 1) miktar4--
            5 -> if (miktar5 >= 1) miktar5--
            6 -> if (miktar6 >= 1) miktar6--
            7 -> if (miktar7 >= 1) miktar7--
            8 -> if (miktar8 >= 1) miktar8--
            9 -> if (miktar9 >= 1) miktar9--
            10 -> if (miktar10 >= 1) miktar10--
            else -> return
        }
        miktarGuncelle(urunNo)

    }



    private fun miktarGuncelle(urunNo: Int){
        val txtview = when(urunNo){
            1 -> tvmiktar
            2 -> tvmiktar2
            3 -> tvmiktar3
            4 -> tvmiktar4
            5 -> tvmiktar5
            6 -> tvmiktar6
            7 -> tvmiktar7
            8 -> tvmiktar8
            9 -> tvmiktar9

            else -> return
        }
        val miktar = when (urunNo) {
            1 -> miktar1
            2 -> miktar2
            3 -> miktar3
            4 -> miktar4
            5 -> miktar5
            6 -> miktar6
            7 -> miktar7
            8 -> miktar8
            9 -> miktar9
            10 -> miktar10
            else -> 0 // Geçersiz ürün numarası
        }
        txtview.text = miktar.toString()

    }

    override fun onPause() {
        super.onPause()

        // SharedPreferences'e kaydetme
        val editor = sharedPreferences.edit()
        editor.putInt("miktar1", miktar1)
        editor.putInt("miktar2", miktar2)
        editor.putInt("miktar3", miktar3)
        editor.putInt("miktar4", miktar4)
        editor.putInt("miktar5", miktar5)
        editor.putInt("miktar6", miktar6)
        editor.putInt("miktar7", miktar7)
        editor.putInt("miktar8", miktar8)
        editor.putInt("miktar9", miktar9)
        editor.putInt("miktar10", miktar10)

        // Ürün isimlerini kaydetme
        editor.putString("urun1", txturun.text.toString())
        editor.putString("urun2", txturun2.text.toString())
        editor.putString("urun3", txturun4.text.toString())
        editor.putString("urun4", txturun5.text.toString())
        editor.putString("urun5", txturun6.text.toString())
        editor.putString("urun6", txturun7.text.toString())
        editor.putString("urun7", txturun8.text.toString())
        editor.putString("urun8", txturun9.text.toString())
        editor.putString("urun9", txturun10.text.toString())
        editor.putString("urun10", txturun11.text.toString())


        editor.apply()
    }



}