package com.mohammad.presentation.contactsList.chat

import com.mohammad.framework.db.entity.Message

interface ChatContract {
    interface Interactor {
        suspend fun fetchMessages(userId: String): List<Message>
        suspend fun addMessage(message: Message)
    }
}