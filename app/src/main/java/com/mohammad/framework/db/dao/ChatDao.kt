package com.mohammad.framework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mohammad.framework.db.model.Contact
import com.mohammad.framework.db.model.Message

@Dao
interface ChatDao {
    @Insert
    fun addMessage(message: Message)

    @Query("SELECT * FROM Message WHERE userId = :userId ORDER BY createdAt ASC")
    fun getMessages(userId: String) : List<Message>
}
