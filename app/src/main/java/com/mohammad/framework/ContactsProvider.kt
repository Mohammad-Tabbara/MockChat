package com.mohammad.framework

import com.mohammad.domain.IContactsProvider
import com.mohammad.framework.db.model.Contact
import java.util.*
import kotlin.math.abs

class ContactsProvider: IContactsProvider {
    override suspend fun generateContacts(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        for(i in 0 until 200) {
            val contact = Contact(i.toString(), UUID.randomUUID().toString(), randomImage())
            contacts.add(contact)
        }
        return contacts
    }

    private fun randomImage(): String {
        return when(abs(Random().nextInt() % 3)) {
            0 -> "https://i.ya-webdesign.com/images/512x512-png-images-5.png"
            1 -> "https://www.logolynx.com/images/logolynx/88/8810b2cd552089221253ae709274e86b.png"
            2 -> "https://upload.wikimedia.org/wikipedia/commons/6/63/Icon_Bird_512x512.png"
            else -> "https://i.ya-webdesign.com/images/512x512-png-images-5.png"
        }
    }
}