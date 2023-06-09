package com.example.cyphersystemcompanion

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toolbar
import com.example.cyphersystemcompanion.databinding.FragmentDmBinding
import com.example.cyphersystemcompanion.databinding.FragmentPlayerBinding

class PlayerFragment : Fragment() {
    private var _binding: FragmentPlayerBinding? = null
    private val binding get() = _binding!!
    private lateinit var listView: ListView
    private val data = listOf(
        "Choose Your Type",
        "Choose Your Flavor",
        "Choose Your Descriptor",
        "Choose Your Focus",
        "Choose Your Abilities",
        "Pick A Name",
        "Make Some Character Art!!"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{

        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

}