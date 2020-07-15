package com.mohammad.presentation.contactsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mohammad.framework.db.model.Contact
import com.mohammad.presentation._common.BaseViewModel
import com.mohammad.presentation._common.extensions.setError
import com.mohammad.presentation._common.extensions.setLoading
import com.mohammad.presentation._common.extensions.setSuccess
import com.mohammad.presentation._common.models.Resource
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject

class ContactsListViewModel @Inject constructor(private val interactor: ContactsListContract.Interactor) : BaseViewModel() {

    private val fetchContactsResult = MutableLiveData<Resource<List<Contact>>>()
    val fetchContactsResultLiveData: LiveData<Resource<List<Contact>>> get() = fetchContactsResult

    fun fetchContactsAsync() {
        launch {
            withContext(Dispatchers.IO) {
                fetchContacts()
            }
        }
    }

    private suspend fun fetchContacts() {
        fetchContactsResult.setLoading()
        try {
            fetchContactsResult.setSuccess(interactor.fetchContacts())
        } catch (exception: Exception) {
            fetchContactsResult.setError(exception = exception)
        }
    }

}
