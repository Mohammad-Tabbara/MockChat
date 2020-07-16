package com.mohammad.framework

import com.mohammad.domain.IContactsProvider
import com.mohammad.domain.IContentManager
import com.mohammad.domain.ILocalDatabase
import com.mohammad.framework.db.model.Contact
import javax.inject.Inject

class ContentManager @Inject constructor(private val localDatabase: ILocalDatabase, private val contactsProvider: IContactsProvider): IContentManager {
    override suspend fun fetchContacts(): List<Contact> {
        // TODO: Create Random generated Contacts
        val contacts = localDatabase.getContactsDao().getContacts()
        return if(contacts.isNotEmpty()) {
            contacts
        } else {
            val generatedContacts = contactsProvider.generateContacts()
            localDatabase.getContactsDao().addContacts(generatedContacts)
            generatedContacts
        }
    }
}
