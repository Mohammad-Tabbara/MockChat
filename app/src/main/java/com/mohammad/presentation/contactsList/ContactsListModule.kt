package com.mohammad.presentation.contactsList

import androidx.lifecycle.ViewModel
import com.mohammad.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ContactsListModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactsListViewModel::class)
    abstract fun bindContactsListViewModel(contactsListViewModel: ContactsListViewModel): ViewModel
}