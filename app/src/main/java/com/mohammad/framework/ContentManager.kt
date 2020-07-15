package com.mohammad.framework

import com.mohammad.domain.IContentManager
import com.mohammad.domain.ILocalDatabase
import com.mohammad.framework.db.model.Contact
import javax.inject.Inject

class ContentManager @Inject constructor(private val localDatabase: ILocalDatabase): IContentManager {
    override suspend fun fetchContacts(): List<Contact> {
        // TODO: Create Random generated Contacts
        val list = listOf(Contact("1", "mohammad", "https://upload.wikimedia.org/wikipedia/commons/6/63/Icon_Bird_512x512.png"))
        val contacts = localDatabase.getContactsDao().getContacts()
        return if(contacts.isNotEmpty()) {
            contacts
        } else {
            localDatabase.getContactsDao().addContacts(list)
            list
        }
    }
}
