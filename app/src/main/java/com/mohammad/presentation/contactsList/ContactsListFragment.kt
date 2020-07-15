package com.mohammad.presentation.contactsList

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohammad.R
import com.mohammad.framework.db.model.Contact
import com.mohammad.presentation._common.BaseFragment
import com.mohammad.presentation._common.extensions.inTransaction
import com.mohammad.presentation._common.models.ResourceState
import com.mohammad.presentation.contactsList.chat.ChatFragment
import kotlinx.android.synthetic.main.fragment_contacts_list.*
import javax.inject.Inject

class ContactsListFragment : BaseFragment() {

    override val fragmentLayout: Int = R.layout.fragment_contacts_list

    @Inject
    lateinit var viewModel: ContactsListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchContactsAsync()
        observeContactsList()
    }

    private fun observeContactsList() {
        viewModel.fetchContactsResultLiveData.observe(viewLifecycleOwner, Observer { contactsResource ->
            when(contactsResource.state) {
                ResourceState.LOADING -> {

                }
                ResourceState.SUCCESS -> {
                    contactsResource.data?.let { contacts ->
                        initContactsList(contacts)
                    }
                }
                ResourceState.ERROR -> {

                }
            }
        })
    }

    private fun initContactsList(contacts: List<Contact>) {
        contactsList.apply {
            adapter = ContactsAdapter(contacts) { selectedContact ->
                parentFragmentManager.inTransaction {
                    replace(R.id.mainContainer, ChatFragment.newInstance(selectedContact.id))
                }
            }
            layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContactsListFragment()
    }
}
