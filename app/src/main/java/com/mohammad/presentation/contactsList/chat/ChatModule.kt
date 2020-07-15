package com.mohammad.presentation.contactsList.chat

import androidx.lifecycle.ViewModel
import com.mohammad.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ChatModule {
    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    abstract fun bindChatViewModel(chatViewModel: ChatViewModel): ViewModel
}