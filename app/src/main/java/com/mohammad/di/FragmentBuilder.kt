package com.mohammad.di

import com.mohammad.presentation.contactsList.ContactsListFragment
import com.mohammad.presentation.contactsList.ContactsListModule
import com.mohammad.presentation.contactsList.chat.ChatFragment
import com.mohammad.presentation.contactsList.chat.ChatModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder{

    @ContributesAndroidInjector(modules = [ContactsListModule::class])
    abstract fun bindTrendingFragment(): ContactsListFragment

    @ContributesAndroidInjector(modules = [ChatModule::class])
    abstract fun bindSettingsFragment(): ChatFragment
}