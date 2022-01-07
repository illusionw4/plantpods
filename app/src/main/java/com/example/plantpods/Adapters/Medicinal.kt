package com.example.plantpods.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plantpods.Model.Medicinalmodel
import com.example.plantpods.R

class Medicinal(private val context: com.example.plantpods.Typesplant.Medicinal, private val Plantlist: ArrayList<Medicinalmodel>) : RecyclerView.Adapter<Medicinal.Planthold>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Planthold {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.medicinalcardy, parent, false)
        return Planthold(itemView)
    }

    override fun onBindViewHolder(holder: Planthold, position: Int) {
        val currentitem = Plantlist[position]
        holder.mplantname.text = currentitem.plantname
        holder.mdescr.text = currentitem.description

        Glide.with(context).load(currentitem.image).placeholder(R.drawable.progressanim).into(holder.mimage)
    }

    override fun getItemCount(): Int {
        return Plantlist.size
    }

    class Planthold(itemView : View): RecyclerView.ViewHolder(itemView){

        var mplantname: TextView = itemView.findViewById(R.id.plantname)
        var mdescr: TextView = itemView.findViewById(R.id.description)
        var mimage: ImageView = itemView.findViewById(R.id.image)
    }
}