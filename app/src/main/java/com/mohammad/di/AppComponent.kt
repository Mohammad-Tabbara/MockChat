package com.mohammad.di

import android.app.Application
import com.mohammad.presentation.MockChatApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class,AppModule::class])
interface AppComponent: AndroidInjector<MockChatApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application):Builder
        fun appModule(appModule: AppModule): Builder
        fun build():AppComponent
    }

}