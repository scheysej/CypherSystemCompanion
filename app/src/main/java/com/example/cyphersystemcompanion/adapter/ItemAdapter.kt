package com.example.cyphersystemcompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.R
import com.example.cyphersystemcompanion.data.Foci

class ItemAdapter(private val fociList : ArrayList<Foci>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.foci_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return fociList.count()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentitem = fociList[position]

        holder.name.text = currentitem.name
        holder.description.text = currentitem.description
        holder.intrusions.text = currentitem.intrusions
    }

    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.fociNameTv)
        val description: TextView = itemView.findViewById(R.id.fociDescTv)
        val intrusions: TextView = itemView.findViewById(R.id.fociIntrusionsTv)

    }
}