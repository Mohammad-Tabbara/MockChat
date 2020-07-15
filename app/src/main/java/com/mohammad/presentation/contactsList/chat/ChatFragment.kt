package com.mohammad.presentation.contactsList.chat

import android.os.Bundle
import com.mohammad.R
import com.mohammad.presentation._common.BaseFragment
import javax.inject.Inject


class ChatFragment : BaseFragment() {

    override val fragmentLayout: Int = R.layout.fragment_chat

    private var contactId: String? = null

    @Inject
    lateinit var viewModel: ChatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            contactId = it.getString(CONTACT_ID)
        }
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
