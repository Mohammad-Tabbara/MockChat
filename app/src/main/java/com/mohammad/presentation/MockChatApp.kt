package com.mohammad.presentation

import com.mohammad.di.AppModule
import com.mohammad.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MockChatApp: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent
        .builder().application(this).appModule(AppModule()).build()
}