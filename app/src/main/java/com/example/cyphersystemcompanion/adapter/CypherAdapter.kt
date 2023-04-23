package com.example.cyphersystemcompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.R
import com.example.cyphersystemcompanion.data.Cyphers

class CypherAdapter(private val cypherList : ArrayList<Cyphers>) : RecyclerView.Adapter<CypherAdapter.CypherViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CypherViewHolder {
        val cypherView = LayoutInflater.from(parent.context).inflate(R.layout.cypher_item, parent, false)
        return CypherViewHolder(cypherView)
    }

    override fun getItemCount(): Int {
        return cypherList.count()
    }

    override fun onBindViewHolder(holder: CypherViewHolder, position: Int) {
        val currentitem = cypherList[position]

        holder.name.text = currentitem.name
        holder.effect.text = currentitem.effect
//        holder.roll.text = currentitem.roll
//        holder.modifier.text = currentitem.modifier.toString()
    }

    class CypherViewHolder(cypherView : View) : RecyclerView.ViewHolder(cypherView){
        val name: TextView = itemView.findViewById(R.id.cypherNameTv)
        val effect: TextView = itemView.findViewById(R.id.cypherEffectTv)
//        val roll: TextView = itemView.findViewById(R.id.cypherRollTv)
//        val modifier : TextView = itemView.findViewById(R.id.cypherModTv)

    }
}