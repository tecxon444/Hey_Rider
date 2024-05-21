package com.example.hey_rider.Fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hey_rider.R
import com.example.hey_rider.databinding.FragmentChatRoomBinding


class ChatRoomFragment : Fragment() {
    private lateinit var binding: FragmentChatRoomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatRoomBinding.inflate(layoutInflater)
        //getValue()
        onSendBtnClick()
        return binding.root
    }

    private fun onSendBtnClick() {
        binding.sendButton.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val messageText = binding.messageEditText.text.toString().trim()
        if (messageText.isNotEmpty()) {
            // Create message view and add it to chat layout
            addMessageToChat(messageText)

            // Clear message input field
            binding.messageEditText.text.clear()

            // Scroll chat layout to bottom
            binding.chatScrollView.post {
                binding.chatScrollView.fullScroll(ScrollView.FOCUS_DOWN)
            }
        }
    }

    private fun addMessageToChat(message: String) {

        val messageView = createMessageView(message)
        binding.chatLayout.addView(messageView)

        // Scroll chat layout to bottom
        binding.chatScrollView.post {
            binding.chatScrollView.fullScroll(ScrollView.FOCUS_DOWN)
        }
    }

    private fun createMessageView(message: String): TextView {
        val textView = TextView(requireContext())
        textView.text = message
        textView.setPadding(16, 8, 16, 8)
        textView.setBackgroundResource(R.drawable.outgoing_message_bg)
        textView.setTextColor(Color.BLACK)
        return textView
    }

    /* private fun getValue() {
        /* val bundle = arguments
         val name = bundle?.getString("username")
         binding.usernameTextView.text = name
         val profileImg = bundle?.getInt("profile")?:R.drawable.profile_image
         binding.circularImageView.setImageResource(profileImg)*/

         val username = arguments?.getString("username")
         val profileImage = arguments?.getInt("profileImage") ?: R.drawable.profile

         binding.usernameTextView.text = username
         binding.circularImageView.setImageResource(profileImage)
     }*/



}