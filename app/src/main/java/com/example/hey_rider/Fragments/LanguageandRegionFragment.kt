package com.example.hey_rider.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentLanguageandRegionBinding


class LanguageandRegionFragment : Fragment() {
    private lateinit var binding : FragmentLanguageandRegionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLanguageandRegionBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_languageandRegionFragment_to_preferencesFragment)
        }

        setupLanguageAndRegion()

        return binding.root
    }

    private fun setupLanguageAndRegion() {
        binding.spinnerLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val language = parent.getItemAtPosition(position).toString()
                // Handle language preference change
                Toast.makeText(context, "Language: $language", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.spinnerRegion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val region = parent.getItemAtPosition(position).toString()
                // Handle region preference change
                Toast.makeText(context, "Region: $region", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }


}