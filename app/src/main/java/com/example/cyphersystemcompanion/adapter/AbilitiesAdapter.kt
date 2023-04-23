package com.example.cyphersystemcompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.R
import com.example.cyphersystemcompanion.data.Abilities

class AbilitiesAdapter(private val abilitiesList : ArrayList<Abilities>) : RecyclerView.Adapter<AbilitiesAdapter.AbilitiesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.abilities_item, parent, false)
        return AbilitiesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return abilitiesList.count()
    }

    override fun onBindViewHolder(holder: AbilitiesViewHolder, position: Int) {
        val currentitem = abilitiesList[position]

        holder.name.text = currentitem.name
        holder.description.text = currentitem.description
        holder.tier.text = currentitem.tier
    }

    class AbilitiesViewHolder(abilitiesView : View) : RecyclerView.ViewHolder(abilitiesView){
        val name: TextView = itemView.findViewById(R.id.abilitiesNameTv)
        val description: TextView = itemView.findViewById(R.id.abilitiesDescTv)
        val tier: TextView = abilitiesView.findViewById(R.id.abilitiesTierTv)

    }
}