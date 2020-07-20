package com.mohammad.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mohammad.Constants
import com.mohammad.domain.ILocalDatabase
import com.mohammad.framework.db.dao.ChatDao
import com.mohammad.framework.db.dao.ContactsDao
import com.mohammad.framework.db.entity.Contact
import com.mohammad.framework.db.entity.Message


@Database(entities = [Contact::class, Message::class], version = 1, exportSchema = false)
abstract class LocalDatabase: RoomDatabase(), ILocalDatabase {
    abstract override fun getContactsDao() : ContactsDao
    abstract override fun getMessageDao(): ChatDao

    companion object {
        fun newInstance(context: Context) =
            Room.databaseBuilder(context, LocalDatabase::class.java, Constants.LOCAL_DB)
                .addMigrations()
                .build()
    }

}
