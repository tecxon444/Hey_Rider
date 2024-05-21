package com.example.hey_rider.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hey_rider.databinding.ChatListItemBinding
import com.example.hey_rider.model.Chat

class ChatAdapter(private val chatList: List<Chat>,
                  private val clickListener: (Chat) -> Unit
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(val binding : ChatListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        // access username and profile pic
        fun bind(chat: Chat, clickListener: (Chat) -> Unit){
            binding.usernameTextView.text = chat.username
            binding.circularImageView.setImageResource(chat.profileImage)

            binding.root.setOnClickListener {
                clickListener(chat)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ChatListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
       val currentChat = chatList[position]
        holder.bind(currentChat,clickListener)
    }
}