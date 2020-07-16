package com.mohammad.domain

import com.mohammad.framework.db.model.Contact
import com.mohammad.framework.db.model.Message

interface IContentManager {
    suspend fun fetchContacts(): List<Contact>
    suspend fun fetchMessages(userId: String): List<Message>
    suspend fun addMessage(message: Message)
}
