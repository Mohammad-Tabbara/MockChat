package com.mohammad.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mohammad.Constants
import com.mohammad.domain.ILocalDatabase
import com.mohammad.framework.db.dao.ContactsDao
import com.mohammad.framework.db.model.Contact


@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class LocalDatabase: RoomDatabase(), ILocalDatabase {
    abstract override fun getContactsDao() : ContactsDao

    companion object {
        fun newInstance(context: Context) =
            Room.databaseBuilder(context, LocalDatabase::class.java, Constants.LOCAL_DB)
                .addMigrations()
                .build()
    }

}
