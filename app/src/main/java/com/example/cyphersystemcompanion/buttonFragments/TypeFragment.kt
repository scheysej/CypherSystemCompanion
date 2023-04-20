package com.example.cyphersystemcompanion.buttonFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cyphersystemcompanion.databinding.FragmentTypeBinding

class TypeFragment : Fragment() {
    private var _binding: FragmentTypeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstaceState: Bundle?
    ): View?{
        _binding = FragmentTypeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}