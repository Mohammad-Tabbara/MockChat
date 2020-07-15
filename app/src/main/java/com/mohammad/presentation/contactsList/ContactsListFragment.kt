package com.mohammad.presentation.contactsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohammad.R
import com.mohammad.presentation._common.BaseFragment
import com.mohammad.presentation.contactsList.chat.ChatFragment

class ContactsListFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts_list, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChatFragment()
    }
}