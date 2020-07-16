package com.mohammad.presentation._common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.DaggerFragment

open class BaseFragment : DaggerFragment() {

    @LayoutRes
    open val fragmentLayout: Int = 0

    open val fragmentTitle: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(fragmentLayout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        activity?.title = fragmentTitle
        val canPop = parentFragmentManager.backStackEntryCount > 0
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(canPop);
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayShowHomeEnabled(canPop);
    }

}
