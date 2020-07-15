package com.mohammad.presentation.contactsList

import androidx.lifecycle.ViewModel
import com.mohammad.di.annotations.ViewModelKey
import com.mohammad.domain.IContentManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ContactsListModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactsListViewModel::class)
    abstract fun bindContactsListViewModel(contactsListViewModel: ContactsListViewModel): ViewModel

    companion object {
        @Provides
        fun provideContactsListInteractor(contentManager: IContentManager): ContactsListContract.Interactor = ContactsListInteractor(contentManager)
    }
}
