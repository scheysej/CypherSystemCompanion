package com.example.cyphersystemcompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.R
import com.example.cyphersystemcompanion.data.Type

class TypeAdapter(private val typeList : ArrayList<Type>) : RecyclerView.Adapter<TypeAdapter.TypeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val typeView = LayoutInflater.from(parent.context).inflate(R.layout.type_item, parent, false)
        return TypeViewHolder(typeView)
    }

    override fun getItemCount(): Int {
        return typeList.count()
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        val currentitem = typeList[position]

        holder.name.text = currentitem.name
    }

    class TypeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.typeNameTv)

    }
}