package com.mohammad.framework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mohammad.framework.db.entity.Contact
import com.mohammad.framework.db.model.DisplayContact

@Dao
interface ContactsDao {
    @Insert
    fun addContacts(contacts: List<Contact>)

    @Query("SELECT c.*, m.lastMessage, m.lastMessageCreatedAt FROM Contact c JOIN (SELECT m.userId, m.message lastMessage, MAX(m.createdAt) lastMessageCreatedAt FROM Message m GROUP BY m.userId) m ON c.id = m.userId UNION ALL SELECT c.*, NULL lastMessage, NULL lastMessageCreatedAt FROM Contact c LEFT JOIN Message m ON m.userId = c.id WHERE m.id IS NULL ORDER BY lastMessageCreatedAt DESC")
    fun getContacts() : List<DisplayContact>
}
