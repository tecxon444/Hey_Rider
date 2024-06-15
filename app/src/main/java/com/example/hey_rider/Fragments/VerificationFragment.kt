package com.example.hey_rider.Fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentVerificationBinding


class VerificationFragment : Fragment() {

    private lateinit var binding : FragmentVerificationBinding
    private val documentUploadLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            uploadDocument(it)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVerificationBinding.inflate(layoutInflater)

        binding.btnUploadId.setOnClickListener {
            documentUploadLauncher.launch("application/pdf")
        }

        binding.btnReSubmit.setOnClickListener {
            documentUploadLauncher.launch("application/pdf")
        }

        updateVerificationStatus("Pending")

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_profileFragment)
        }

        return binding.root
    }

    private fun uploadDocument(uri: Uri) {
        // Here you would handle the upload to your backend
        // For this example, we'll just simulate it
        simulateUpload(uri)
    }

    private fun simulateUpload(uri: Uri) {
        // Simulate a successful upload and verification process
        updateVerificationStatus("Verified")
    }

    private fun updateVerificationStatus(status: String) {
        binding.tvVerificationstatus.text = status
        when(status){
            "Pending"->{
                binding.tvVerificationstatus.setTextColor(resources.getColor(android.R.color.holo_orange_dark))
                binding.btnReSubmit.visibility = View.GONE
            }"Verified"->{
            binding.tvVerificationstatus.setTextColor(resources.getColor(android.R.color.holo_green_dark))
            binding.btnReSubmit.visibility = View.GONE
        }"Rejected"->{
            binding.tvVerificationstatus.setTextColor(resources.getColor(android.R.color.holo_red_dark))
            binding.btnReSubmit.visibility = View.GONE
        }

        }
    }
}