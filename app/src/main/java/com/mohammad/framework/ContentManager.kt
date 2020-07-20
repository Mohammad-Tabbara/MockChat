package com.mohammad.framework

import com.mohammad.domain.IContactsProvider
import com.mohammad.domain.IContentManager
import com.mohammad.domain.ILocalDatabase
import com.mohammad.framework.db.entity.Contact
import com.mohammad.framework.db.model.DisplayContact
import com.mohammad.framework.db.entity.Message
import javax.inject.Inject

class ContentManager @Inject constructor(private val localDatabase: ILocalDatabase, private val contactsProvider: IContactsProvider): IContentManager {
    override suspend fun fetchContacts(): List<DisplayContact> {
        val contacts = mutableListOf<DisplayContact>()
        contacts.addAll(localDatabase.getContactsDao().getMessagedContacts())
        contacts.addAll(localDatabase.getContactsDao().getFreshContacts())
        return if(contacts.isNotEmpty()) {
            contacts
        } else {
            val generatedContacts = contactsProvider.generateContacts()
            localDatabase.getContactsDao().addContacts(generatedContacts)
            generatedContacts.toDisplayContact()
        }
    }

    override suspend fun fetchMessages(userId: String): List<Message> {
        return localDatabase.getMessageDao().getMessages(userId)
    }

    override suspend fun addMessage(message: Message) {
        localDatabase.getMessageDao().addMessage(message)
    }
}

private fun List<Contact>.toDisplayContact(): List<DisplayContact> {
    return map {
        return@map DisplayContact(it.id, it.name, it.imagePath)
    }
}
