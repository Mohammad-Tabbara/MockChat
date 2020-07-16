package com.mohammad.presentation.contactsList.chat

import androidx.lifecycle.ViewModel
import com.mohammad.di.annotations.ViewModelKey
import com.mohammad.domain.IContentManager
import com.mohammad.presentation.contactsList.ContactsListContract
import com.mohammad.presentation.contactsList.ContactsListInteractor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ChatModule {
    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    abstract fun bindChatViewModel(chatViewModel: ChatViewModel): ViewModel

    companion object {
        @Provides
        fun provideChatInteractor(contentManager: IContentManager): ChatContract.Interactor = ChatInteractor(contentManager)
    }
}