package com.example.hey_rider.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hey_rider.LogoutDialog
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
  private lateinit var binding:FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.apply {
            view5.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_verificationFragment)
            }
            view7.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
            }
            view6.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_rideHistoryFragment)
            }
            view8.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_preferencesFragment)
            }
            view11.setOnClickListener {
                LogoutDialog().show(parentFragmentManager,"Log Out")
            }
            view10.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_aboutFragment)
            }
        }

        return binding.root
    }

}