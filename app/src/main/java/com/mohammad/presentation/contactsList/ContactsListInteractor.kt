package com.mohammad.presentation.contactsList

import com.mohammad.domain.IContentManager
import com.mohammad.framework.db.model.Contact
import javax.inject.Inject

class ContactsListInteractor @Inject constructor(val contentManager: IContentManager): ContactsListContract.Interactor {
    override suspend fun fetchContacts(): List<Contact> {
        return contentManager.fetchContacts()
    }
}
