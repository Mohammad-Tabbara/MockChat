package com.mohammad.domain

import com.mohammad.framework.db.dao.ChatDao
import com.mohammad.framework.db.dao.ContactsDao

interface ILocalDatabase {
    fun getContactsDao(): ContactsDao
    fun getMessageDao(): ChatDao
}
