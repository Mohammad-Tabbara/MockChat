package com.mohammad.di

import com.mohammad.domain.IContentManager
import com.mohammad.domain.ILocalDatabase
import com.mohammad.framework.ContentManager
import com.mohammad.framework.db.LocalDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [BaseModule::class])
class AppModule {
    
    @Singleton
    @Provides
    fun provideContentManager(): IContentManager = ContentManager()

    @Singleton
    @Provides
    fun provideLocalDatabase(): ILocalDatabase = LocalDatabase()

}