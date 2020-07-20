package com.mohammad.presentation.contactsList.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohammad.R
import com.mohammad.framework.db.entity.Message
import kotlinx.android.synthetic.main.sent_chat_message_layout.view.*

class ChatAdapter(private val messages: List<Message>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    enum class ViewType { SENT, RECEIVED }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutId = if (viewType == ViewType.SENT.ordinal) {
            R.layout.sent_chat_message_layout
        } else {
            R.layout.received_chat_message_layout
        }
        val itemView =
            LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemViewType(position: Int): Int {
        return if(messages[position].fromMe) {
            ViewType.SENT.ordinal
        } else {
            ViewType.RECEIVED.ordinal
        }
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(messages[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(message: Message) {
            itemView.messageText.text = message.message
        }
    }
}