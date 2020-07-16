package com.mohammad.presentation.contactsList.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohammad.R
import com.mohammad.presentation._common.BaseFragment
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
