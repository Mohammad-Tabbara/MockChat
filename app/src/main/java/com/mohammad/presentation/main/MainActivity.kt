package com.mohammad.presentation.main

import android.os.Bundle
import com.mohammad.R
import com.mohammad.presentation._common.BaseActivity
import com.mohammad.presentation._common.extensions.inTransaction
import com.mohammad.presentation.contactsList.ContactsListFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       supportFragmentManager.inTransaction(true) {
           add(R.id.mainContainer, ContactsListFragment.newInstance())
       }
    }
}
