package com.example.cyphersystemcompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.cyphersystemcompanion.PlayerFragment
import com.example.cyphersystemcompanion.R

class PlayerAdapter(private val navController: NavController) {
    class PlayerViewHolder(val view: View){
        val button1 = view.findViewById<Button>(R.id.gm)
        val button2 = view.findViewById<Button>(R.id.home)
    }

    fun onBindViewHolder(holder: PlayerViewHolder, position: Int){
        holder.button1.setOnClickListener{
            navController.navigate(R.id.action_playerFragment_to_dmFragment)
        }
        holder.button2.setOnClickListener{
            navController.navigate(R.id.action_playerFragment_to_dashboardFragment)
        }
    }
}