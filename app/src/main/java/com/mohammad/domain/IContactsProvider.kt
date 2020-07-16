package com.mohammad.domain

import com.mohammad.framework.db.model.Contact

interface IContactsProvider {
    suspend fun generateContacts(): List<Contact>
}
