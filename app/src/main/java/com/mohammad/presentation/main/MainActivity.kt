package com.mohammad.presentation.main

import android.os.Bundle
import com.mohammad.R
import com.mohammad.presentation._common.BaseActivity
import com.mohammad.presentation._common.extensions.inTransaction
import com.mohammad.presentation.contactsList.ContactsListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLayout()
    }

    private fun initLayout() {
        setSupportActionBar(appBar)
        supportFragmentManager.inTransaction(true) {
            add(R.id.mainContainer, ContactsListFragment.newInstance())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
