package com.mohammad.domain

import com.mohammad.framework.db.model.Contact

interface IContentManager {
    suspend fun fetchContacts(): List<Contact>
}
