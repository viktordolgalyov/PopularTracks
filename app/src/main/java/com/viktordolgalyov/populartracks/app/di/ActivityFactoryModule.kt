package com.viktordolgalyov.populartracks.app.di

import com.viktordolgalyov.populartracks.component.home.HomeActivity
import com.viktordolgalyov.populartracks.component.trending.di.TrendingFragmentFactoryModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityFactoryModule {
    @ContributesAndroidInjector(modules = arrayOf(
            TrendingFragmentFactoryModule::class
    ))
    abstract fun homeActivity(): HomeActivity
}