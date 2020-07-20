package com.mohammad.presentation.contactsList.chat

import com.mohammad.domain.IContentManager
import com.mohammad.framework.db.entity.Message

class ChatInteractor(private val contentManager: IContentManager): ChatContract.Interactor {
    override suspend fun fetchMessages(userId: String): List<Message> {
        return contentManager.fetchMessages(userId)
    }

    override suspend fun addMessage(message: Message) {
        return contentManager.addMessage(message)
    }
}