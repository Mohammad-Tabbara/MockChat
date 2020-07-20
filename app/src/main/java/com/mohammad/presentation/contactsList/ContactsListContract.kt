package com.mohammad.presentation.contactsList

import com.mohammad.framework.db.model.DisplayContact

interface ContactsListContract {
    interface Interactor {
        suspend fun fetchContacts(): List<DisplayContact>
    }
}
