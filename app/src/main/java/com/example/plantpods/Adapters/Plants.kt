package com.example.plantpods.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plantpods.Model.Plantmodel
import com.example.plantpods.R
import com.example.plantpods.Typesplant.Flowering
import com.example.plantpods.Typesplant.Medicinal

class Plants(private val context: Flowering, private val Plantlist: ArrayList<Plantmodel>) : RecyclerView.Adapter<Plants.Planthold>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Planthold {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.plantcard, parent, false)
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