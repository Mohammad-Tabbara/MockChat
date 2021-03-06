package com.mohammad.di

import com.mohammad.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector(modules = [ViewModelFactoryModule::class, FragmentBuilder::class])
    abstract fun bindMainActivity(): MainActivity
}