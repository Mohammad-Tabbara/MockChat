package com.mohammad.presentation._common.extensions

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.util.UUID

fun FragmentManager.inTransaction(firstScreen: Boolean = false, func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    if(!firstScreen) {
        fragmentTransaction.addToBackStack(UUID.randomUUID().toString())
    }
    fragmentTransaction.commit()
}
