package com.example.hey_rider.Fragments

import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentEditProfileBinding


class EditProfileFragment : Fragment() {
    private lateinit var binding : FragmentEditProfileBinding
    private var profilePictureUri: Uri? = null // Declare profilePictureUri here
    private val profilePictureLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            profilePictureUri = it
            displayProfilePicture(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(layoutInflater)

        binding.ivProfilePicture.setOnClickListener {
            profilePictureLauncher.launch("image/*")
        }

        binding.btnSave.setOnClickListener {
            saveProfile()
        }

        binding.btnCancel.setOnClickListener {
            loadProfile()
        }

        addTextWatchers()
        loadProfile()

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment)
        }

        return binding.root
    }

    private fun addTextWatchers() {
        binding.etName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrBlank()) {
                    binding.etName.error = "Name is required"
                }
            }
        })
        binding.etContact.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrBlank()) {
                    binding.etContact.error = "Mobile number is required"
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    binding.etContact.error = "Invalid Mobile number "
                }
            }
        })
        binding.etEmail.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (s.isNullOrBlank()){
                    binding.etEmail.error = "Email id is required"
                }else if (!android.util.Patterns.PHONE.matcher(s).matches()){
                    binding.etEmail.error = "Invalid Email id "
                }
            }
        })
    }

    private fun loadProfile() {
        // Simulate loading profile data. Replace this with actual data loading from Firebase.
//        binding.etName.setText("John Doe")
//        binding.etBio.setText("A short bio about John.")
//        binding.etEmail.setText("John.doe@email.com")
//        binding.etContact.setText("9999999999")

        // Load profile picture from a stored URL
        val profilePictureUrl = "https://example.com/path/to/profile/picture.jpg" // Replace with actual URL
        displayProfilePicture(profilePictureUrl)
    }

    private fun displayProfilePicture(uri: Uri) {
        Glide.with(this)
            .load(uri)
            .placeholder(R.drawable.user)
            .error(R.drawable.user)
            .into(binding.ivProfilePicture)
    }

    private fun displayProfilePicture(url: String) {
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.user)
            .error(R.drawable.user)
            .into(binding.ivProfilePicture)
    }

    private fun saveProfile() {
        val name = binding.etName.text.toString()
        val bio = binding.etBio.text.toString()
        val email = binding.etEmail.text.toString()
        val contact = binding.etContact.text.toString()

        if (name.isBlank()) {
            binding.etName.error = "Name is required"
            return
        }

        if (bio.isBlank()) {
            binding.etBio.error = "Bio is required"
            return
        }

        if (email.isBlank()) {
            binding.etEmail.error = "Valid email is reuquired"
            return
        }
        if (contact.isBlank() ){  //|| (!android.util.Patterns.EMAIL_ADDRESS.matcher(contact).matches() && !android.util.Patterns.PHONE.matcher(contact).matches())
            binding.etContact.error = "Valid mobile number  is required"

            return
        }

        // Simulate saving profile data. Replace this with actual data saving to Firebase.
        Toast.makeText(context, "Profile saved successfully", Toast.LENGTH_SHORT).show()
    }

}