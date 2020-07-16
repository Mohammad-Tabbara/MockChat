package com.mohammad.presentation.contactsList.chat

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohammad.R
import com.mohammad.framework.db.model.Message
import com.mohammad.presentation._common.BaseFragment
import com.mohammad.presentation._common.models.ResourceState
import kotlinx.android.synthetic.main.fragment_chat.*
import java.util.*
import javax.inject.Inject


class ChatFragment : BaseFragment() {

    override val fragmentLayout: Int = R.layout.fragment_chat

    private var contactId: String? = null
    private var contactName: String? = null

    override val fragmentTitle: String
        get() = contactName ?: ""

    @Inject
    lateinit var viewModel: ChatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            contactId = it.getString(CONTACT_ID)
            contactName = it.getString(CONTACT_NAME)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        viewModel.getUserChatAsync(contactId ?: "")
        sendButton.setOnClickListener {
            if(messageEditText.text.isNotEmpty()) {
                viewModel.addMessageAsync(
                    Message(
                        contactId ?: "",
                        messageEditText.text.toString(),
                        true,
                        Date().time
                    )
                )
            }
        }
    }

    private fun initObservers() {
        observeChat()
        observeAddMessage()
    }

    private fun observeChat() {
        viewModel.getUserChatResultLiveData.observe(viewLifecycleOwner, Observer { chatResource ->
            when (chatResource.state) {
                ResourceState.LOADING -> {
                    showLoading()
                }
                ResourceState.SUCCESS -> {
                    endLoading()
                    chatResource.data?.let { messages ->
                        initChatList(messages)
                    }
                }
                ResourceState.ERROR -> {
                    endLoading()
                    // TODO: Handle Exception
                }
            }
        })
    }

    private fun observeAddMessage() {
        viewModel.addMessageResultLiveData.observe(viewLifecycleOwner, Observer { chatResource ->
            when (chatResource.state) {
                ResourceState.SUCCESS -> {
                    chatResource.data?.let { messages ->
                        initChatList(messages)
                    }
                }
                ResourceState.ERROR -> {
                    // TODO: Handle Exception
                }
            }
        })
    }

    private fun showLoading() {
        chatList.visibility = View.GONE
        loading.visibility = View.VISIBLE
    }

    private fun endLoading() {
        chatList.visibility = View.VISIBLE
        loading.visibility = View.GONE
    }

    private fun initChatList(messages: List<Message>) {
        chatList.apply {
            adapter = ChatAdapter(messages)
            layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        private const val CONTACT_ID = "contactId"
        private const val CONTACT_NAME = "contactName"
        @JvmStatic
        fun newInstance(contactId: String, contactName: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(CONTACT_ID, contactId)
                    putString(CONTACT_NAME, contactName)
                }
            }
    }
}
