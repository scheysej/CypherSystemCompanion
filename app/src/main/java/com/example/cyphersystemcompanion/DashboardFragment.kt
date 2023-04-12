package com.example.cyphersystemcompanion

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.cyphersystemcompanion.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

//    override fun onCreate(savedInstanceState: Bundle?){
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}