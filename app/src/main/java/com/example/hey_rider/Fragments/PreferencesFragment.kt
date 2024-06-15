package com.example.hey_rider.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentPreferencesBinding

class PreferencesFragment : Fragment() {
    private lateinit var binding: FragmentPreferencesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPreferencesBinding.inflate(layoutInflater)


        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_preferencesFragment_to_profileFragment)
        }

        binding.viewLanguage.setOnClickListener {
            findNavController().navigate(R.id.action_preferencesFragment_to_languageandRegionFragment)
        }

        binding.viewNotification.setOnClickListener {
            findNavController().navigate(R.id.action_preferencesFragment_to_notificationFragment)
        }

        binding.viewPrivacy.setOnClickListener {
            findNavController().navigate(R.id.action_preferencesFragment_to_privacyFragment)
        }

        return binding.root
    }

}