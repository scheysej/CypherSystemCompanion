package com.example.cyphersystemcompanion

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cyphersystemcompanion.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.focusButton.setOnClickListener{
            val intent = Intent(context, FociActivity::class.java)
            startActivity(intent)
        }
        binding.typeButton.setOnClickListener{
            val intent = Intent(context, TypeActivity::class.java)
            startActivity(intent)
        }
        binding.descButton.setOnClickListener{
            val intent = Intent(context, DescriptorActivity::class.java)
            startActivity(intent)
        }
        binding.flavorButton.setOnClickListener{
            val intent = Intent(context, FlavorActivity::class.java)
            startActivity(intent)
        }
        binding.abilitiesButton.setOnClickListener{
            val intent = Intent(context, AbilitiesActivity::class.java)
            startActivity(intent)
        }

        return view

    }


    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}