package com.mohammad.presentation.contactsList.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohammad.R
import com.mohammad.presentation._common.BaseFragment


class ChatFragment : BaseFragment() {
    private var contactId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            contactId = it.getString(CONTACT_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    companion object {
        private const val CONTACT_ID = "contactId"
        @JvmStatic
        fun newInstance(contactId: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(CONTACT_ID, contactId)
                }
            }
    }
}