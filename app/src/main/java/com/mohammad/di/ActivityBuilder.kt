package com.mohammad.di

import com.mohammad.presentation.main.MainActivity
import com.mohammad.presentation.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector(modules = [MainModule::class, ViewModelFactoryModule::class, FragmentBuilder::class])
    abstract fun bindMainActivity(): MainActivity
}