package com.example.hey_rider.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private lateinit var binding : FragmentNotificationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(layoutInflater)

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_notificationFragment_to_preferencesFragment)
        }

        setupNotificationPreferences()
        return binding.root
    }

    private fun setupNotificationPreferences() {
        binding.switchEmailNotifications.setOnCheckedChangeListener { _, isChecked ->
            // Handle email notification preference change
            Toast.makeText(context, "Email Notifications: $isChecked", Toast.LENGTH_SHORT).show()
        }

        binding.switchSmsNotifications.setOnCheckedChangeListener { _, isChecked ->
            // Handle SMS notification preference change
            Toast.makeText(context, "SMS Notifications: $isChecked", Toast.LENGTH_SHORT).show()
        }

        binding.switchInAppNotifications.setOnCheckedChangeListener { _, isChecked ->
            // Handle in-app notification preference change
            Toast.makeText(context, "In-App Notifications: $isChecked", Toast.LENGTH_SHORT).show()
        }
    }

}