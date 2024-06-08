package com.mrcaracal.havadurumumrc.view

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrcaracal.havadurumumrc.R
import kotlinx.android.synthetic.main.recycler_tarif.view.*

class RecyclerAdapter(val tariflistesi : ArrayList<String>,val yemektarif : ArrayList<String>, val tarifgorsel : ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.YemekTarifleri>() {


    private lateinit var onItemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    class YemekTarifleri (itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekTarifleri {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_tarif,parent,false)
        return YemekTarifleri(itemView)

    }

    override fun getItemCount(): Int {

        return tariflistesi.size

    }

    override fun onBindViewHolder(holder: YemekTarifleri, position: Int) {

        holder.itemView.recyclerviewText.text=tariflistesi.get(position)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,tarif_activity::class.java)
            intent.putExtra("tarifisim",tariflistesi.get(position))
            intent.putExtra("tarif",yemektarif.get(position))
            intent.putExtra("yemekgorsel",tarifgorsel.get(position))


            holder.itemView.context.startActivity(intent)

        }

    }
    fun getYemekTarifi(position: Int): String {
        return yemektarif[position]
    }


}