package com.example.cyphersystemcompanion

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.cyphersystemcompanion.databinding.FragmentDmBinding

class DmFragment : Fragment() {
    private var _binding: FragmentDmBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        _binding = FragmentDmBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}