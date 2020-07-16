package com.mohammad.framework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mohammad.framework.db.model.Contact

@Dao
interface ContactsDao {
    @Insert
    fun addContacts(contacts: List<Contact>)

    // TODO: Reform Query to contain the last message
    @Query("SELECT * FROM Contact")
    fun getContacts() : List<Contact>
}
