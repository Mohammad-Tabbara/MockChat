package com.mohammad.presentation.contactsList.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mohammad.framework.db.entity.Message
import com.mohammad.presentation._common.BaseViewModel
import com.mohammad.presentation._common.extensions.setError
import com.mohammad.presentation._common.extensions.setLoading
import com.mohammad.presentation._common.extensions.setSuccess
import com.mohammad.presentation._common.models.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.*
import javax.inject.Inject

class ChatViewModel @Inject constructor(val interactor: ChatContract.Interactor) : BaseViewModel() {

    private val getUserChatResult = MutableLiveData<Resource<List<Message>>>()
    val getUserChatResultLiveData: LiveData<Resource<List<Message>>> get() = getUserChatResult

    private val addMessageResult = MutableLiveData<Resource<List<Message>>>()
    val addMessageResultLiveData: LiveData<Resource<List<Message>>> get() = addMessageResult

    fun addMessageAsync(message: Message) {
        launch {
            withContext(Dispatchers.IO) {
                addMessage(message)
            }
            delay(500)
            withContext(Dispatchers.IO) {
                message.fromMe = false
                addMessage(message)
            }
        }
    }

    private suspend fun addMessage(message: Message) {
        message.createdAt = Date().time
        addMessageResult.setLoading()
        try {
            interactor.addMessage(message)
            addMessageResult.setSuccess(interactor.fetchMessages(message.userId))
        } catch (exception: Exception) {
            addMessageResult.setError(exception = exception)
        }
    }

    fun getUserChatAsync(userId: String) {
        launch {
            withContext(Dispatchers.IO) {
                getUserChat(userId)
            }
        }
    }

    private suspend fun getUserChat(userId: String) {
        getUserChatResult.setLoading()
        try {
            getUserChatResult.setSuccess(interactor.fetchMessages(userId))
        } catch (exception: Exception) {
            getUserChatResult.setError(exception = exception)
        }
    }
}
