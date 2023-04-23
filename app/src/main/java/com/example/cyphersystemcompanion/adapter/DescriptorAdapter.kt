package com.example.cyphersystemcompanion.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphersystemcompanion.R
import com.example.cyphersystemcompanion.data.Descriptors
import com.example.cyphersystemcompanion.data.Foci
import com.example.cyphersystemcompanion.databinding.ActivityFociBinding

class DescriptorAdapter(private val descriptorList : ArrayList<Descriptors>) : RecyclerView.Adapter<DescriptorAdapter.DescriptorViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptorViewHolder {
        val descriptorView = LayoutInflater.from(parent.context).inflate(R.layout.descriptor_item, parent, false)
        return DescriptorViewHolder(descriptorView)
    }

    override fun getItemCount(): Int {
        return descriptorList.count()
    }

    override fun onBindViewHolder(holder: DescriptorViewHolder, position: Int) {
        val currentitem = descriptorList[position]

        holder.name.text = currentitem.name
        holder.description.text = currentitem.description
    }

    class DescriptorViewHolder(descriptorView : View) : RecyclerView.ViewHolder(descriptorView){
        val name: TextView = itemView.findViewById(R.id.descriptorsNameTv)
        val description: TextView = itemView.findViewById(R.id.descriptorsDescTv)

    }
}