package com.mohammad.presentation.contactsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohammad.R
import com.mohammad.framework.db.model.Contact
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.contact_layout.view.*

class ContactsAdapter(
    private val contacts: List<Contact>,
    private val itemClickListener: (Contact) -> Unit
) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.contact_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(contacts[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(contact: Contact, itemClickListener: (Contact) -> Unit) {
            itemView.contactName.text = contact.name
            Picasso.get().load(contact.imagePath).into(itemView.userAvatar)
            itemView.userAvatar
            itemView.rootView.setOnClickListener {
                itemClickListener(contact)
            }
        }

    }
}
