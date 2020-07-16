package com.mohammad.di

import android.content.Context
import com.mohammad.domain.IContactsProvider
import com.mohammad.domain.IContentManager
import com.mohammad.domain.ILocalDatabase
import com.mohammad.framework.ContactsProvider
import com.mohammad.framework.ContentManager
import com.mohammad.framework.db.LocalDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [BaseModule::class])
class AppModule {
    
    @Singleton
    @Provides
    fun provideContentManager(localDatabase: ILocalDatabase, contactsProvider: IContactsProvider): IContentManager = ContentManager(localDatabase, contactsProvider)

    @Singleton
    @Provides
    fun provideLocalDatabase(context: Context): ILocalDatabase = LocalDatabase.newInstance(context)

    @Singleton
    @Provides
    fun provideContactsProvider(): IContactsProvider = ContactsProvider()

}
