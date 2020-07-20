package com.mohammad.domain

import com.mohammad.framework.db.entity.Contact

interface IContactsProvider {
    suspend fun generateContacts(): List<Contact>
}
