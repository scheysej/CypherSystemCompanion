package com.example.cyphersystemcompanion.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.R
import com.example.cyphersystemcompanion.data.Flavor

class FlavorAdapter(private val flavorList : ArrayList<Flavor>) : RecyclerView.Adapter<FlavorAdapter.FlavorViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlavorViewHolder {
        val flavorView = LayoutInflater.from(parent.context).inflate(R.layout.flavor_item, parent, false)
        return FlavorViewHolder(flavorView)
    }

    override fun getItemCount(): Int {
        return flavorList.count()
    }

    override fun onBindViewHolder(holder: FlavorViewHolder, position: Int) {
        val currentitem = flavorList[position]

        holder.name.text = currentitem.name
    }

    class FlavorViewHolder(flavorView : View) : RecyclerView.ViewHolder(flavorView){
        val name: TextView = itemView.findViewById(R.id.flavorNameTv)
    }
}