package com.mohammad.presentation.contactsList

import com.mohammad.framework.db.model.Contact

interface ContactsListContract {
    interface Interactor {
        suspend fun fetchContacts(): List<Contact>
    }
}
