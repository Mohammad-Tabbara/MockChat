package com.mohammad.presentation.contactsList.chat

import com.mohammad.framework.db.model.Message

interface ChatContract {
    interface Interactor {
        suspend fun fetchMessages(userId: String): List<Message>
        suspend fun addMessage(message: Message)
    }
}