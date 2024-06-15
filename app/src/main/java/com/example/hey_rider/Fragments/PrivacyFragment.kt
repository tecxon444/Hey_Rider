package com.example.hey_rider.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentPrivacyBinding

class PrivacyFragment : Fragment() {
    private lateinit var binding: FragmentPrivacyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPrivacyBinding.inflate(layoutInflater)

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_privacyFragment_to_preferencesFragment)
        }

        setupPrivacySettings()

        return binding.root
    }

    private fun setupPrivacySettings() {
        binding.privacySettingsGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = group.findViewById<RadioButton>(checkedId)
            val privacySetting = radioButton.text.toString()
            // Handle privacy setting change
            Toast.makeText(context, "Privacy Setting: $privacySetting", Toast.LENGTH_SHORT).show()
        }
    }

}