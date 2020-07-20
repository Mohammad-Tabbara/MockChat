package com.mohammad.presentation.contactsList

import com.mohammad.domain.IContentManager
import com.mohammad.framework.db.model.DisplayContact
import javax.inject.Inject

class ContactsListInteractor @Inject constructor(private val contentManager: IContentManager): ContactsListContract.Interactor {
    override suspend fun fetchContacts(): List<DisplayContact> {
        return contentManager.fetchContacts()
    }
}
