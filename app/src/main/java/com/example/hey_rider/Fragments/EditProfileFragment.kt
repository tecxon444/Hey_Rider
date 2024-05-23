package com.example.hey_rider.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.navigation.fragment.findNavController
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {
   private val bioStatus = arrayOf("Drive","Ride","Both")
   private lateinit var binding:FragmentEditProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDropdown()

        binding.cross.setOnClickListener {
            findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment)
        }
    }

    private fun setDropdown(){
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1, bioStatus)
        (binding.statusDropdown.editText as? AutoCompleteTextView)?.apply {
            setOnDismissListener {
                binding.statusDropdown.clearFocus()
            }
        }?.setAdapter(adapter)
    }
}