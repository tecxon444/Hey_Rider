package com.example.hey_rider.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hey_rider.R
import com.example.hey_rider.adapters.ChatAdapter
import com.example.hey_rider.databinding.FragmentChatBinding
import com.example.hey_rider.model.Chat

class ChatFragment : Fragment() {
    private lateinit var binding : FragmentChatBinding
    private lateinit var chatAdapter: ChatAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(layoutInflater)


        val chatList = getDummyList()
        chatAdapter  = ChatAdapter(chatList){ chat ->
            openChatRoom(chat)
        }

//        binding.chatRecyclerView.adapter = chatAdapter
//        binding.chatRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.chatRecyclerView.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }


    private fun getDummyList(): List<Chat> {
        // Replace this with your actual data retrieval logic
        return listOf(
            Chat("User 1", R.drawable.profile1),
            Chat("User 2", R.drawable.profile2),
            Chat("User 3", R.drawable.profile3)
        )
    }

    private fun openChatRoom(chat: Chat) {
        val bundle = Bundle()
        bundle.putString("username", chat.username)
        bundle.putInt("profileImage",chat.profileImage)

        findNavController().navigate(R.id.action_chatFragment_to_chatRoomFragment)
    }

}