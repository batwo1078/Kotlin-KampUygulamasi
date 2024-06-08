package com.mrcaracal.havadurumumrc.view

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.mrcaracal.havadurumumrc.R
import kotlinx.android.synthetic.main.activity_tarif.*
import kotlinx.android.synthetic.main.activity_yemek.*

class Activity_yemek : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek)



        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {

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
                //R.id.nav_liste -> {
                    //val intent = Intent(this,liste_activity ::class.java)
                    //startActivity(intent)
               // }
                R.id.nav_tarif -> {
                    val intent = Intent(this,Activity_yemek ::class.java)
                    startActivity(intent)
                }

            }

            drawerLayout.closeDrawers()
            true
        }

        geribtn3.setOnClickListener{
            finish()
        }



        var tarifisim = ArrayList<String>()
        tarifisim.add("- Kamp Böreği")
        tarifisim.add("- Kamp Güveç")
        tarifisim.add("- Kamp Omleti")
        tarifisim.add("- Kamp Makarna Salatası")

        var yemektarif = ArrayList<String>()
        yemektarif.add("Malzemeler\n" +
                "- Yufka veya tortilla\n" +
                "- Sucuk veya pastırma\n" +
                "- Kaşar peyniri\n" +
                "- Yumurta\n" +
                "- Sıvı yağ\n\n" +
                "Yapılışı\n" +
                "1. Yufkaları veya tortillaları açın.\n" +
                "2. İçine sucuk, pastırma ve rendelenmiş kaşar peyniri ekleyin.\n" +
                "3. Rulo şeklinde sarın ve üzerine yumurta sürün.\n" +
                "4. Tavada yağda kızartarak pişirin.\n")
        yemektarif.add(" Malzemeler:\n" +
                "Tavuk parçaları\n" +
                "Patates\n" +
                "Soğan\n" +
                "Biber\n" +
                "Domates\n" +
                "Baharatlar (tuz, karabiber, kekik)\n\n" +
                " Yapılışı:\n" +
                "1. Tavuk parçalarını, doğranmış patatesleri,\n " +
                "soğanı, biberi ve\n" +
                " domatesi bir güveç kabına yerleştirin.\n" +
                "2. Üzerine tuz, karabiber, kekik gibi baharatları ekleyin.\n" +
                "3. Güveç kapağını kapatın ve ateşte veya mangalda pişirin.")
        yemektarif.add(" Malzemeler:\n" +
                "Yumurta\n" +
                "Süt\n" +
                "Tuz ve karabiber\n" +
                "İsteğe bağlı: doğranmış biber, sucuk veya peynir\n\n" +
                " Yapılışı:\n" +
                "1. Yumurtaları bir kaba kırın.\n" +
                "2. Süt, tuz ve karabiber ekleyin, iyice çırpın.\n" +
                "3. Tavaya biraz yağ ekleyin, karışımı dökün.\n" +
                "4. İsteğe bağlı malzemeleri ekleyin ve karışımı pişirin.")
        yemektarif.add(" Malzemeler:\n" +
                "Makarna\n" +
                "Konserve mısır\n" +
                "Ton balığı veya haşlanmış tavuk (isteğe bağlı)\n" +
                "Zeytinyağı, tuz ve karabiber\n\n" +
                " Yapılışı:\n" +
                "1. Makarnayı haşlayın ve süzün.\n" +
                "2. Konserve mısırla ve isteğe bağlı ton balığı veya \n" +
                "tavukla karıştırın." +
                "3. Zeytinyağı, tuz ve karabiber ekleyerek karıştırın.")



      /*  val isim1Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ygorsel1)
        val isim2Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ygorsel2)
        val isim3Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ygorsel3)
        val isim4Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ygorsel)

        var yemekgorsel = ArrayList<Bitmap>()
        yemekgorsel.add(isim1Bitmap)
        yemekgorsel.add(isim2Bitmap)
        yemekgorsel.add(isim3Bitmap)
        yemekgorsel.add(isim4Bitmap)*/


        val gorselId = R.drawable.ygorsel
        val gorsel1Id = R.drawable.ygorsel1
        val gorsel2Id = R.drawable.ygorsel2
        val gorsel3Id = R.drawable.ygorsel3

        var yemekgorsellistesi = ArrayList<Int>()
        yemekgorsellistesi.add(gorselId)
        yemekgorsellistesi.add(gorsel1Id)
        yemekgorsellistesi.add(gorsel2Id)
        yemekgorsellistesi.add(gorsel3Id)




        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager


        val adapter = RecyclerAdapter(tarifisim,yemektarif,yemekgorsellistesi)
        recyclerview.adapter = adapter

        adapter.setOnItemClickListener(object : RecyclerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                // Kullanıcı bir öğeye tıkladığında yapılacak işlemler buraya gelecek
                val selectedTarif = adapter.getYemekTarifi(position)

                // Şimdi seçilen tarifi kullanarak istediğiniz Activity'e geçebilir veya kullanabilirsiniz.
                // Örneğin, tarif bilgisini bir başka Activity'ye göndermek için:
                val intent = Intent(this@Activity_yemek, tarif_activity::class.java)
                intent.putExtra("tarif", selectedTarif)
                startActivity(intent)
            }
        })

    }
}