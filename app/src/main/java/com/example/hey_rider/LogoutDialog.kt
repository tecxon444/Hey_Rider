package com.example.hey_rider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hey_rider.databinding.DialogBotmshetLogoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LogoutDialog: BottomSheetDialogFragment() {

    private lateinit var binding : DialogBotmshetLogoutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        binding = DialogBotmshetLogoutBinding.inflate(inflater,container,false)
        return binding.root
    }
}