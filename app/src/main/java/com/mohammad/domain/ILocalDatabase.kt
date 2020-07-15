package com.mohammad.domain

import com.mohammad.framework.db.dao.ContactsDao

interface ILocalDatabase {
    fun getContactsDao(): ContactsDao
}
