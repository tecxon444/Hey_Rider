package com.example.hey_rider.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentRideHistoryBinding


class RideHistoryFragment : Fragment() {
    private lateinit var binding: FragmentRideHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRideHistoryBinding.inflate(layoutInflater)

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_rideHistoryFragment_to_profileFragment)
        }

        return binding.root
    }

}