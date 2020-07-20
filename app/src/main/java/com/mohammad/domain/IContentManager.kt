package com.mohammad.domain

import com.mohammad.framework.db.model.DisplayContact
import com.mohammad.framework.db.entity.Message

interface IContentManager {
    suspend fun fetchContacts(): List<DisplayContact>
    suspend fun fetchMessages(userId: String): List<Message>
    suspend fun addMessage(message: Message)
}
